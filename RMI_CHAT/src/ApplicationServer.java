//Liam Iverson

//Core ApplicationServer, required to run first for client connection


import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;



public class ApplicationServer {
	static ArrayList<String> chatRooms = new ArrayList<>();
	static ArrayList<ArrayList<String>> chatLogs = new ArrayList<>();

	//main function and setup
	public static void main(String[] args) throws RemoteException{
		System.out.println("SERVER RUNNING");
		chatRooms.add("ADMIN");
		chatLogs.add(new ArrayList<String>());
		chatLogs.get(0).add("Welcome to Admin Chat");
		
		Registry registry = LocateRegistry.createRegistry(5099);
		registry.rebind(("enterServer"), new enterServerServant());
		registry.rebind(("listRooms"), new listRoomsServant(chatRooms));
		registry.rebind(("addRoom"), new addNewRoomServant());
		registry.rebind(("loadRoom"), new loadRoomServant());
		registry.rebind(("updateChatlogs"), new updateChatServant());
		
		
		
	}
	
	//Internal function to update chat room
	public static void updateChatRooms(String newRoom) throws RemoteException{
		chatRooms.add(newRoom);
		int length = chatRooms.size();
		ArrayList<String> initialLog = new ArrayList<String>();
		initialLog.add("Welcome to " + newRoom + " chat");
		chatLogs.add(initialLog);
		
		
	}
	
	//Internal function to update chatlogs
	public static void updateChatLogs(String message, String room) throws RemoteException{
		System.out.println(room);
		for(int i = 0; i < chatRooms.size(); i++) {
			if(room.equals(chatRooms.get(i))) {
				System.out.println(room);
				chatLogs.get(i).add(message);
			}
		}
		System.out.println(chatLogs);
	}
	
	//Internal function to get current chat rooms
	public static ArrayList<String> getRoom(String room) throws RemoteException{
		int index = 0;
		for(int i = 0; i < chatRooms.size(); i++) {
			if(room.equals(chatRooms.get(i))) {
				index = i;
			}
			
		}
		
		return chatLogs.get(index);
		
	}
	
	 //Internal dummy function to load and preserve data following server shutdown.
	public static ArrayList<String> loadData() throws RemoteException{
		//Dummy function to gather previous data either from a local log or outside server
		//Implement at your discretion
		return chatRooms;
		
	}

}
