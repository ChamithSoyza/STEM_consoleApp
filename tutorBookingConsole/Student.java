package tutorBookingConsole;

public class Student extends User implements Notifiable {
    private String stream;

    public Student(String name, String stream) {
        super(name);
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    @Override
    public String getRole() {
        return "User Role: Student";
    }

    @Override
    public String toString() {
        return super.toString() + " : Student [stream=" + stream + "]";
    }

    @Override
    public void notify(String msg) {
        System.out.println("Notification for Student: Dear " + getName() + " : " + msg);
    }
}
