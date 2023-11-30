/* 
A Science teacher wants to fill up the students' test marks in an application. Teacher enters the mark in the application based on Roll Number. 
But the teacher wants to store the marks in an increasing order while the mark has been entered. Develop a java application to collect the mark and 
immediately insert the mark in an increasing order with the help of List Collection.
*/

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
/* Sample Input Output : 
Enter the number of students : 5 
Enter the marks of student1 :45
Marks of students : [45]
Enter the marks of student2 :47
Marks of students : [45, 47]
Enter the marks of student3 :30
Marks of students : [30, 45, 47]
Enter the marks of student4 :43
Marks of students : [30, 43, 45, 47]
Enter the marks of student5 :50
Marks of students : [30, 43, 45, 47, 50]
*/
