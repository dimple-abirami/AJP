/*
Most of the operating systems use different commands to check the availability of hosts in  the network. You are asked to design a 
Network Connection Checker application. Initially  the application collects a host name from the user and to check the availability of host, 
if  available then display the properties of host such as hostname, dotted IP address, IP version  and class of IP address, otherwise display 
a message “The host is unable to reach”.
*/

import java.net.*;
import java.util.*;

public class networkConnectionChecker 
{
    public static void main(String[] args){
        String host;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Host name : ");
        host = sc.nextLine();
        
        try{
            InetAddress address = InetAddress.getByName(host);
            if(address.isReachable(128)){
                System.out.println("HostName : "+address.getHostName());
                System.out.println("IP Address : "+address.getHostAddress());
                byte[] add = address.getAddress();
                System.out.println('IPv%d',(add.length==4)?4:6);
                int fbyte = add[0];
                char cls = 'a';
                if((fbyte & 0x80)==0) cls = 'A';
                else if((fbyte & 0xC0)==0x80) cls = 'B';
                else if((fbyte & 0xE0)==0xC0) cls = 'C';
                else if((fbyte & 0xF0)==0xE0) cls = 'D';
                
                System.out.println("Class "+cls);
            }
            else{
                System.out.println("The Host is unable to reach");
            }
        }
        catch(unknownHostException e){
            System.out.println("Couldnot find host IP address");
        }
    }
}
