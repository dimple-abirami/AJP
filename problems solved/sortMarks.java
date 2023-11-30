import java.util.*;

public class SortMarks {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       List marks = new ArrayList();
       System.out.print("Enter the number of students : ");
       int total_students = sc.nextInt();
       for(int i=0;i<total_students;i++){
           System.out.print("Enter the marks of student"+(i+1)+" :");
           marks.add(sc.nextInt());
           Collections.sort(marks);
           System.out.println("Marks of students : "+marks);
       }
    }
}
