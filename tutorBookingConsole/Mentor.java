package tutorBookingConsole;

public class Mentor extends User implements Notifiable {
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

    @Override
    public void notify(String msg) {
        System.out.println("Notification for Mentor : Dear " + getName() + " : " + msg);
    }
}
