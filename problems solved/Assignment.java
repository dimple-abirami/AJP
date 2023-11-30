import java.util.*;

public class Assignment {
    Stack<Integer> s = new Stack<>();
    Scanner sc = new Scanner(System.in);

    public int getTotalStudents() {
        System.out.print("Enter the number of students : ");
        return (sc.nextInt());
    }

    public void submit() {
        System.out.println("Eight Students can submit now...");
        for (int i = 0; i < 8; i++) {
            s.push(sc.nextInt());
            System.out.println("Submitted students : " + s);
        }
    }

    public void announce() {
        System.out.println("Evaluated for : ");
        for (int i = 0; i < 4; i++) {
            if (!s.isEmpty()) {
                System.out.println(s.pop());
            } else {
                return;
            }
        }
    }

    public void remainingStudents(int n) {
        System.out.println("Remaining Students can submit now...");
        for (int i = 0; i < n; i++) {
            s.push(sc.nextInt());
            System.out.println("Submitted students : " + s);
        }
    }
    
    public void announceRemaining(){
        System.out.println("Evaluated for : ");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Assignment a = new Assignment();
        int total_students = a.getTotalStudents();
        int remaining_students = total_students;

        while (remaining_students > 0) {
            if (remaining_students >= 8) {
                a.submit();
                remaining_students -= 8;
            } else {
                a.remainingStudents(remaining_students);
                remaining_students = 0;
            }
            a.announce();
        }a.announceRemaining();
        
    }
}
