/* 
A Mathematics teacher asked the students to submit the assignment note one by one on the table and he restricted the number of submissions to 8.
He has to correct the note by picking the note which is on top. Once he completed the correction of 4 notes then called the reg no of the student 
to collect the note. After that he asked the next 8 students to submit the note. After each 4 of the notes are completed he calls the students to 
collect until all the notes have been completed. Find appropriate collection class to implement this scenario
*/
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

/* Sample Input Output : 
Enter the number of students : 12
Eight Students can submit now...
101
Submitted students : [101]
102
Submitted students : [101, 102]
103
Submitted students : [101, 102, 103]
104
Submitted students : [101, 102, 103, 104]
105
Submitted students : [101, 102, 103, 104, 105]
106
Submitted students : [101, 102, 103, 104, 105, 106]
107
Submitted students : [101, 102, 103, 104, 105, 106, 107]
108
Submitted students : [101, 102, 103, 104, 105, 106, 107, 108]
Evaluated for : 
108
107
106
105
Remaining Students can submit now...
109
Submitted students : [101, 102, 103, 104, 109]
110
Submitted students : [101, 102, 103, 104, 109, 110]
111
Submitted students : [101, 102, 103, 104, 109, 110, 111]
112
Submitted students : [101, 102, 103, 104, 109, 110, 111, 112]
Evaluated for : 
112
111
110
109
Evaluated for : 
104
103
102
101
*/
