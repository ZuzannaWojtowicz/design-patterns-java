package Root.Primary;

public class Employee extends Root.Comparables.Employee {
    private String name;
    private String surname;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public void setName(String newName) { name = newName; }
    public void setSurname(String newSurname) { surname = newSurname; }
    public Root.Interfaces.Object clone() { return new Employee(name, surname); }

    public Employee (String n, String s) {
        name = n;
        surname = s;
    }
}