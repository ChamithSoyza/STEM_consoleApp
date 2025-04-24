package tutorBookingConsole;

public abstract class Session {
    private int sessionId;
    private Student student;
    private Mentor mentor;
    private String dateTime;
    private static int nextSessionId = 1;

    public Session(Student student, Mentor mentor, String dateTime) {
        this.sessionId = nextSessionId++;
        this.student = student;
        this.mentor = mentor;
        this.dateTime = dateTime;
    }

    public int getSessionId() {
        return sessionId;
    }

    public Student getStudent() {
        return student;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public String getDateTime() {
        return dateTime;
    }

    /**
     * @return THis will return the basic details of the subclass which implemented the session class.
     */
    public abstract String getDetails();

    /**
     * @return This will return the session Type which will return a string value for print purposes.
     */
    public abstract String getType();

    @Override
    public String toString() {
        return super.toString() + "Session Details : " + sessionId + "[Student : " + student.getName() + " Mentor : " + mentor.getName();
    }
}
