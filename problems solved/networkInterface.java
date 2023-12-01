/*
A Company wants to develop an application to scan the network interface details and a  physical address of a host. Your host needs to collect 
the host name and then examine the IP  address of host. After that it scans and prints all the possible network interface names found  in the 
host. And then print the physical address (MAC) of the host. 
*/

import java.util.*;
import java.net.*;
import java.io.*;

public class NetworkInterface {
    public static void main(String[] args) {
        String host;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Host name : ");
        host = sc.nextLine();

        try {
            InetAddress address = InetAddress.getByName(host);
            System.out.println("HostName : " + address.getHostName());
            System.out.println("IP Address : " + address.getHostAddress());

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                System.out.println("NetworkInterface : " + network.getName());

                if (network != null && network.getInetAddresses().hasMoreElements()) {
                    byte[] mac = network.getHardwareAddress();
                    if (mac != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02x%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        System.out.println("MAC Address : " + sb.toString());
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not find host IP address");
        } catch (SocketException e) {
            System.out.println("Error while retrieving network interfaces: " + e.getMessage());
        }
    }
}

