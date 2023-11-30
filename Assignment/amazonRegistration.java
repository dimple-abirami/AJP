import java.util.*;

public class amazonRegistration{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        HashMap<String, HashSet<Integer>> collegeMap = new HashMap<>();
        System.out.println("... AMAZON ...");
        System.out.println("Registration Portal" + "\n");
        
        while (true) {
            
            int flag=0;
            System.out.print("Enter Applicant Name : ");
            String appName = sc.nextLine();
            
            System.out.print("Enter College Name : ");
            String collegeName = sc.nextLine();
            collegeName = collegeName.toLowerCase();
            
            System.out.print("Enter College Registration Number : ");
            int regNo = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter CGPA : ");
            double cgpa = sc.nextDouble();
            
            if (cgpa<8.5){
                System.out.println("Sorry..You are not eligible..!");
            }
            
            else if (cgpa>10){
                System.out.println("Enter a valid CGPA..!");
            }
            
            else{
                
                if (!collegeMap.containsKey(collegeName)) {
                    collegeMap.put(collegeName, new HashSet<>());
                }
                
                HashSet<Integer> regNumbers = collegeMap.get(collegeName);
                
                if (regNumbers.contains(regNo)) {
                    System.out.println("You have already Registered ...!");
                    flag=1;
                }
                
                else {
                regNumbers.add(regNo);
                    if (regNumbers.size() > 20) {
                        System.out.println("Maximum students reached for this college.");
                        flag=1;
                    }
                }
                
                if(flag==0){
                System.out.println("Registration successful!");
                }
                
                System.out.print("Do you want to continue (1 for yes, 0 for no): ");
                int f = sc.nextInt();
                sc.nextLine();
                
                if (f == 0) {
                    break;
                }
            }
        }
    }
}
