package modelsPackage;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int salary;
    private String position;
    private String password;

    public Employee(int id, String firstName, String lastName, int age, int salary, String position, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            final Employee other = (Employee) obj;
            if (this.id == other.id) {
                return true;
            }
        }
        return false;
    }

}
