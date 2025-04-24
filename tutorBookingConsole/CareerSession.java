package tutorBookingConsole;

public class CareerSession extends Session{
    private String topic;

    public CareerSession(Student student, Mentor mentor, String dateTime, String topic) {
        super(student, mentor, dateTime);
        this.topic = topic;
    }

    @Override
    public String getDetails() {
        return "[Topic : <" + topic + ">  Session Scheduled: " + super.getDateTime() + " ]";
    }

    @Override
    public String getType() {
        return "Career Coach session";
    }
}
