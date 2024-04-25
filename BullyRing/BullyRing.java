import java.util.Scanner;

class Process{
	public int id;
	public String status;
	
	public Process(int id){
		this.id = id;
		this.status = "active";
	}
}

public class BullyRing{
	
	Scanner sc;
	Process[] p;
	int n;
	
	public BullyRing(){
		sc = new Scanner(System.in);
	}
	
	public void ring(){
		System.out.println("Enter the number of processes: ");
		n = sc.nextInt();
		
		p = new Process[n];
		for(int i=0;i<n;i++){
			p[i] = new Process(i);
		}
	}
	
	public void performElection(){
		 try{
		 	Thread.sleep(1000);
		 }
		 catch(InterruptedException e){
		 	System.out.println("Error" + e);
		 }
	
	
	System.out.println("Process number " + p[getMaxValue()].id + " fails.");
	p[getMaxValue()].status = "Inactive";
	
	int idOfInitiator = 0;
	boolean overStatus = true;
	
	while(overStatus) {
			
		boolean higherStatus = false;
		
		System.out.println();
		for(int i = idOfInitiator+1; i<n; i++) {
			if(p[i].status == "active") {
				System.out.println("Process " + idOfInitiator + " passes election (" + idOfInitiator + ") message to process" + i);
			}
			higherStatus = true;
		}
		
		if(higherStatus){
			System.out.println();
		for(int i = idOfInitiator+1; i<n; i++) {
			if(p[i].status == "active") {
				System.out.println("Process " + i + " passes ok (" + i + ") message to process" + idOfInitiator);
			}
			idOfInitiator++;
		}
		}
		else { 
			int coord = p[getMaxValue()].id;
			System.out.println("Finally Process " + coord + " is Coordinator");
			for(int i= coord-1; i>0;i--){
				if(p[i].status == "active") {
				System.out.println("Process " + coord + " passes Coordinator (" + coord + ") message to process" + i);
			}
			}
			System.out.println("Election End");
			overStatus = false;
			break;
			
		}
		
	}
	}
	
	public int getMaxValue(){
		int maxIndex = -99;
		int maxValueId = 0;
		for(int i=0;i<p.length;i++){
			if(p[i].status == "active" && p[i].id>maxValueId) {
				maxValueId = p[i].id;
				maxIndex = i;
			}
		}
		return maxValueId;
	}
	
	public static void main(String[] args){
	 BullyRing bully = new BullyRing();
	 
	 bully.ring();
	 bully.performElection();
}
}


