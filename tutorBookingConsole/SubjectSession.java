package tutorBookingConsole;

public class SubjectSession extends Session {
    private String subjectName;

    public SubjectSession(Student student, Mentor mentor, String dateTime, String subjectName) {
        super(student, mentor, dateTime);
        this.subjectName = subjectName;
    }

    @Override
    public String getDetails() {
        return "[Subject : <" + subjectName + ">  Session Scheduled: " + super.getDateTime() + " ]";
    }

    @Override
    public String getType() {
        return "Subject 1-to-1 session";
    }
}
