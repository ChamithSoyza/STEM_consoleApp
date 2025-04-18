package tutorBookingConsole;

public class Mentor extends User {
    private String department;

    public Mentor(String name, String department) {
        super(name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getRole() {
        return "User Role: Mentor";
    }

    @Override
    public String toString() {
        return super.toString() + " : Mentor experienced in" + department + "]";
    }
}
