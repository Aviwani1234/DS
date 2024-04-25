import java.rmi.*;
import java.util.Scanner;

public class client{
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);

try{
	String serverURL = "rmi://localhost/Server";
	ServerIntf serverIntf = 
	(ServerIntf) Naming.lookup(serverURL);
	System.out.println("Enter First Number:");
	double d1 = sc.nextDouble();
	System.out.println("Enter Second Number:");
	double d2 = sc.nextDouble();
	System.out.println("The sum is : "+ serverIntf.add(d1, d2));
}
catch(Exception e){
	System.out.println("Error" + e);
}
}
}
