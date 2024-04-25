import java.util.Scanner;

public class Tring{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int token = 0;
		
		System.out.println("Enter number of nodes :");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.print(" " + i);
		}
		System.out.println(" " + 0);
		
		try{
			while(true){
				System.out.println("Enter sender: ");
				int s = sc.nextInt();
				System.out.println("Enter reveicer: ");
				int r = sc.nextInt();
				System.out.println("Enter data: ");
				int d = sc.nextInt();
				
				System.out.println("Token passing: ");
				
				for(int i=token, j=token; (i % n)!=s; i++, j=(j+1)%n){
					System.out.print(" " + j + "->");
				}
				System.out.println(" " + s);
				System.out.println("sender " + s + " sending data " + d);
				
				for(int i = (s+1)%n; i!=r; i=(i+1)%n){
					System.out.println("Data " + d + "forwarded by " + i);
				}
				System.out.println("receiver " + r + " forwarded by " + d);
				token = s;
			}
		}
		catch(Exception e) {
			System.out.println("Error"+ e);
		}
	}
}
