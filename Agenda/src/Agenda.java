import java.util.Scanner;
import java.util.ArrayList; 

public class Agenda {
	static Scanner reader = new Scanner(System.in);
	static ArrayList<String> events = new ArrayList<String>();
	static ArrayList<Integer> eventTime = new ArrayList<Integer>();
	static int eventCount = 0;
	
	public static void main(String[] args){
		System.out.println("Hi, Welcome to your Daily Planner\n\n");
		mainmenu();
	}
	
	public static void mainmenu(){
			
			System.out.println("1) Display to do list");
			System.out.println("2) Add new event");
			System.out.println("3) Delete an event");
			System.out.println("4) Exit");
			System.out.print("Select one of the following options by entering number: ");
			
			int n;
			
			while(!reader.hasNextInt()){
				System.out.print("Invalid input. Please enter a integer: ");
				reader.next();
			}
			n = reader.nextInt();
		
		    System.out.println();
		    
			if(n == 1){	
				display();
			}else if(n == 2){
				add();
			}else if(n == 3){
				delete();
			}else if(n == 4){
				System.exit(0);
			}else{
				System.out.println("Invalid option please pick from the numbers 1-4.");
				mainmenu();
			}
		
	}
	
	public static void add(){
		System.out.print("Enter the event: ");
		String newevent = reader.nextLine();
		
		System.out.print("Enter the time (hour, 24-hour format): ");
		int timeH = reader.nextInt();
		
		System.out.print("Enter the time(minute): ");
		int timeM = reader.nextInt();
		
		int time = 60 * timeH + timeM;
		int count = 0;
		
		for(int i = 0; i < eventCount; i++){
			if(eventTime.get(i) > time){
				break;
			}
			count++;
		}
		
		eventTime.add(count, time);
		events.add(count, newevent);
		eventCount++;
		
		System.out.println("\n\n");
		mainmenu();
	}
	
	public static void display(){
		
		if (eventCount == 0){
			System.out.println("Nothing on the agenda right now.");
		}else{
			System.out.println("Time \tTo do");
			
			for(int i = 0; i < eventCount; i++){
				int time = eventTime.get(i);
				int hour = (time / 60);
				int minute = (time % 60);
			
				if((minute/10) >= 1){
					System.out.println(hour + ":" + minute + " \t" + events.get(i));
				}else{
					System.out.println(hour + ":0" + minute + " \t" + events.get(i));
				}
			
			}
		}
			
		System.out.print("\nEnter any number to go back to menu: ");
		reader.nextInt();
		
		System.out.println("\n\n");
		mainmenu();
	}
	
	public static void delete(){
		if(eventCount == 0){
			System.out.println("Don't have any event to delete.");
			System.out.println();
			mainmenu();
		}
		
		System.out.print("Enter the time of the event you want to delete (hours): ");
		int hour = reader.nextInt();
		
		System.out.print("Now enter the minute: ");
		int minute = reader.nextInt();
		
		int time = (hour * 60 + minute);
		int count = 0;
		
		for(int i = 0; i < eventCount; i++){
			if(eventTime.get(i) == time){
					eventTime.remove(i);
					events.remove(i);
					eventCount--;
					break;
			}
			count++;
		}
		
		if(count > eventCount){
			System.out.println("There is not event at that time. Try again.");
			delete();
		}
		
		System.out.println("\n\n");
		mainmenu();
	}

}