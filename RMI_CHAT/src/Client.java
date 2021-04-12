//Liam Iverson


//Client Core Application
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		//All the required url calls as defined by the API
		enterServer service = (enterServer) Naming.lookup("rmi://localhost:5099/enterServer");
		listRooms service2 = (listRooms) Naming.lookup("rmi://localhost:5099/listRooms");
		addNewRoom service3 = (addNewRoom) Naming.lookup("rmi://localhost:5099/addRoom");
		LoadRoom service4 = (LoadRoom) Naming.lookup("rmi://localhost:5099/loadRoom");
		updateChat service5 = (updateChat) Naming.lookup("rmi://localhost:5099/updateChatlogs");
		
		
		
		String Command = "";
		String currentRoom = "";
		String name = "";
		String message = "";
		int exit = 0;
		int inRoom = 0;
		
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		
		System.out.println("WELCOME TO THE RMI CHAT APP 50000");
		System.out.println("please enter your name for chat: ");
		
		name = sc.nextLine();
		
		
		
		//main loop, stateless, only requires representations from the server to operate
		while(exit < 1) {
			System.out.println("Welcome " + name + " please select a room below. Or enter CREATE to create a new room");
			System.out.println(service2.listChatRooms(name));
			
			currentRoom = sc.nextLine();
			
			System.out.println(currentRoom);
			
			//Logic to create room 
			if(currentRoom.equals("CREATE")) {
				System.out.println("ENTER THE NEW ROOM NAME: ");
				String newRoom = sc.nextLine();
				//API stateless call
				System.out.println(service3.echo(newRoom));
				
			}else {
				//Internal room logic
				while(inRoom < 1 ) {
					System.out.println(currentRoom);
					ArrayList<String>chats = service4.getRoom(currentRoom);
					System.out.println("----------------------");
					
					for(int i = 0; i < chats.size();i++) {
						System.out.println(chats.get(i));
						
					}
					
					System.out.println("Type message, hit enter to send/refresh. Type EXIT to pick new room.");
					
					message = sc.nextLine();
					
					if(message.equals("EXIT")) {
						inRoom = 1;
					}else if(message.equals("")) {
						//pass
					}
					else {
						String fullMessage = name + ":" + message;
						System.out.println(service5.updateChatLogs(currentRoom, fullMessage));
					} 
				}
				
				inRoom = 0;
				
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
}
