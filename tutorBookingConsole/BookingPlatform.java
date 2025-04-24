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
            }
            else if(input.equals("3")){{
                if(students.isEmpty()){
                    System.out.println("No Students Registered");
                }else{
                    System.out.println("Registered Students");
                    for(Student student: students){
                        System.out.println("- " + student.getName());
                    }
                }
            }}
            else if(input.equals("4")){
                if(mentors.isEmpty()){
                    System.out.println("No Mentors Registered");
                }else{
                    System.out.println("Registered Mentors");
                    for(Mentor mentor: mentors){
                        System.out.println("- " + mentor.getName());
                    }
                }
            }
            else if(input.equals("5")){
                System.out.println("Enter Student's ID: ");
                int studentId = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Mentor's ID :");
                int mentorId  = Integer.parseInt(sc.nextLine());

                if(!userMap.containsKey(studentId) || !(userMap.get(studentId) instanceof Student)){
                    System.out.println("Student ID does not exist");
                    continue;
                }
            }
        }
    }
}
