package Root.Commands;
import java.util.HashMap;

public class Find extends Generic {
    private Root.Interfaces.Command.CommandArguments args = new Root.Interfaces.Command.CommandArguments("", new String[0]);
    public HashMap<String, Root.Interfaces.Collection<Root.Interfaces.Object>> map;

    public Find() { }
    public Find(HashMap<String, Root.Interfaces.Collection<Root.Interfaces.Object>> map) { this.map = map; }
    public String getName() { return "find"; }
    public void setName(String name) { }
    public String[] getArguments() { return args.Arguments; }
    public boolean Dialogue() { return true; }

    public void setArguments(String[] args) 
    {
        this.args = new Root.Interfaces.Command.CommandArguments(getName(), new String[0]);
        this.args.Arguments = args;
    }

    public void Execute() {
        if (getArguments().length < 1) {
            System.out.println("Wrong arguments, try find <name_of_the_class> [<requirement> …]");
            return;
        }
        Root.Interfaces.Collection<Root.Interfaces.Object> sub = map.get(getArguments()[0]);
        if (sub == null) {
            System.out.println("There is no object of type " + getArguments()[0]);
            return;
        }
        var it = sub.GetForwardEnumerator();
        do {
            boolean x = true;
            for (int i = 1; i < getArguments().length; ++i) if (!it.Current().getValue().meetsCondition(getArguments()[i])) {
                x = false;
                break;
            }
            if (x) System.out.println(it.Current().getValue().Print());
        } while (it.MoveNext());
    }
}