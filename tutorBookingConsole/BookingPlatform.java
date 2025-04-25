package tutorBookingConsole;

import java.util.*;

public class BookingPlatform {
    private static List<Student> students = new ArrayList<>();
    private static List<Mentor> mentors = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static Map<Integer, User> userMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Peer Tutor Booking Platform ===");
            System.out.println("1. Register New Student");
            System.out.println("2. Register New Mentor");
            System.out.println("3. List All Students");
            System.out.println("4. List All Mentors");
            System.out.println("5. Book a Session");
            System.out.println("6. List All Sessions");
            System.out.println("7. Cansel a Session");
            System.out.println("8. Exit");
            System.out.println("Enter an Option (1-8) : ");

            String input = sc.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter Student's Name: ");
                String name = sc.nextLine();
                System.out.println("Enter Student's Stream : ");
                String stream = sc.nextLine();

                Student student = new Student(name, stream);
                students.add(student);
                userMap.put(Integer.valueOf(student.getId()), student);
                System.out.println("New Student Registered. ID: " + student.getId() + " | " + student.getName());
            } else if (input.equals("2")) {
                System.out.println("Enter Mentor's Name: ");
                String name = sc.nextLine();
                System.out.println("Enter Mentor's Subject: ");
                String subject = sc.nextLine();

                Mentor mentor = new Mentor(name, subject);
                mentors.add(mentor);
                userMap.put(Integer.valueOf(mentor.getId()), mentor);
                System.out.println("New Mentor Registered. ID: " + mentor.getId() + " | " + mentor.getName());
            } else if (input.equals("3")) {
                {
                    if (students.isEmpty()) {
                        System.out.println("No Students Registered");
                    } else {
                        System.out.println("Registered Students");
                        for (Student student : students) {
                            System.out.println("- " + student.getName());
                        }
                    }
                }
            } else if (input.equals("4")) {
                if (mentors.isEmpty()) {
                    System.out.println("No Mentors Registered");
                } else {
                    System.out.println("Registered Mentors");
                    for (Mentor mentor : mentors) {
                        System.out.println("- " + mentor.getName());
                    }
                }
            } else if (input.equals("5")) {
                System.out.println("Enter Student's ID: ");
                int studentId = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Mentor's ID :");
                int mentorId = Integer.parseInt(sc.nextLine());

                if (!userMap.containsKey(studentId) || !(userMap.get(studentId) instanceof Student)) {
                    System.out.println("Student ID does not exists");
                    continue;
                }
                if (!userMap.containsKey(mentorId) || !(userMap.get(mentorId) instanceof Mentor)) {
                    System.out.println("Mentor ID does not exists");
                }

                Student student = (Student) userMap.get(studentId);
                Mentor mentor = (Mentor) userMap.get(mentorId);

                System.out.println("Please Select a Session Type :");
                System.out.println("1. Subject 1 to 1");
                System.out.println("2. Career Coaching");
                String sessionType = sc.nextLine();

                Session session = null;

                if (sessionType.equals("1")) {
                    System.out.println("Please Enter Subject : ");
                    String subject = sc.nextLine();
                    System.out.println("Please Enter a Date :");
                    String date = sc.nextLine();
                    session = new SubjectSession(student, mentor, date, subject);
                } else if (sessionType.equals("2")) {
                    System.out.println("Please Enter Topic : ");
                    String topic = sc.nextLine();
                    System.out.println("Please Enter a Date : ");
                    String date = sc.nextLine();
                    session = new CareerSession(student, mentor, date, topic);
                } else {
                    System.out.println("Invalid Session Selection");
                }

                sessions.add(session);

                student.notify(" Please note that, New session with ID : " + session.getSessionId() + " booked on, " + session.getDateTime());
                mentor.notify("Please note that, New session with ID : " + session.getSessionId() + "booked on, " + session.getDateTime());

                System.out.println("New Session Booked Successfully!");
                System.out.println(session.getDetails());
            } else if (input.equals("6")) {
                if (sessions.isEmpty()) {
                    System.out.println("No Sessions Created");
                } else {
                    System.out.println("Created Sessions");
                    for (Session session : sessions) {
                        System.out.println("Session Details : " + session);
                    }
                }
            } else if(input.equals("7")){
                System.out.println("Please Enter The Session ID to Cancel : ");
                String sessionIdToCancel = sc.nextLine();

                Session sessionToCancel = null;
                for (Session session: sessions){
                    if(session.getSessionId() == Integer.parseInt(sessionIdToCancel)){
                        sessionToCancel = session;
                        break;
                    }
                }

                if(sessionToCancel == null){
                    System.out.println("No Session Found With This ID : " + sessionIdToCancel);
                    continue;
                }

                sessions.remove(sessionToCancel);
                sessionToCancel.getStudent().notify(" Your Session (ID : " + sessionIdToCancel + ") has been cancelled.");
                sessionToCancel.getMentor().notify(" Please Note Session (ID : " + sessionIdToCancel + ") with Student " + sessionToCancel.getStudent().getName() + "has been cancelled");

                System.out.println("Session Cancelled Successfully!");
            } else if (input.equals("8")) {
                System.out.println("Leaving Console...");
                running = false;
            }else{
                System.out.println("Invalid Option, Please Enter a Value From 1 - 8");
            }
        }
        sc.close();
    }
}
