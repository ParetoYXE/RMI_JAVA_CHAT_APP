import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;



public class ApplicationServer {
	static ArrayList<String> chatRooms = new ArrayList<>();
	static ArrayList<ArrayList<String>> chatLogs = new ArrayList<>();

	
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
	
	
	public static void updateChatRooms(String newRoom) throws RemoteException{
		chatRooms.add(newRoom);
		int length = chatRooms.size();
		ArrayList<String> initialLog = new ArrayList<String>();
		initialLog.add("Welcome to " + newRoom + " chat");
		chatLogs.add(initialLog);
		
		
	}
	
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
	
	public static ArrayList<String> getRoom(String room) throws RemoteException{
		int index = 0;
		for(int i = 0; i < chatRooms.size(); i++) {
			if(room.equals(chatRooms.get(i))) {
				index = i;
			}
			
		}
		
		return chatLogs.get(index);
		
	}

}
