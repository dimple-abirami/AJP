/*
A Company scheduled an interview for the position of office assistance. The applicants are already applied through a web portal and got a reference number.
On the day of interview, the receptionist asks the applicant to register the reference no in the application. Based on the arrival of the applicant the 
interview order is scheduled. Once the interview session of the applicant is over they are asked to leave the company. Find appropriate collection 
class/interface to implement this scenario.
*/

import java.util.*;

public class Interview {
    Queue <Integer> q  = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public int getTotalApplicants() {
        System.out.print("Enter the number of Applicants : ");
        return (sc.nextInt());
    }

    public void register() {
        System.out.println("Enter the Registration Number: ");
        q.add(sc.nextInt());
        System.out.println("Waiting List : " + q);
    }

    public void leave() {
        System.out.println("Interview session completed for : "+ q.remove());
    }

    public static void main(String[] args) {
        Interview i = new Interview();
        int total_applicants = i.getTotalApplicants();
        int reg = 0;
        for(int j=0;j<total_applicants;j++){
            if(reg<total_applicants){
                i.register();
                i.register();
                reg+=2;
            }
            i.leave();
        }

        
    }
}

/*

Enter the number of Applicants : 5
Enter the Registration Number: 
10
Waiting List : [10]
Enter the Registration Number: 
67 
Waiting List : [10, 67]
Interview session completed for : 10
Enter the Registration Number: 
23
Waiting List : [67, 23]
Enter the Registration Number: 
90
Waiting List : [67, 23, 90]
Interview session completed for : 67
Enter the Registration Number: 
78
Waiting List : [23, 90, 78]
Enter the Registration Number: 
23
Waiting List : [23, 90, 78, 23]
Interview session completed for : 23
Interview session completed for : 90
Interview session completed for : 78

*/

