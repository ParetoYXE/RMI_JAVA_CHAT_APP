import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class listRoomsServant extends UnicastRemoteObject implements listRooms {

	/**
	 * 
	 */
	
	
	
	ArrayList<String> chatRoomsMaster = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	
	
	protected listRoomsServant(ArrayList<String> chatRooms) throws RemoteException {
		chatRoomsMaster = chatRooms;
	}

	@Override
	public ArrayList<String> listChatRooms(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return chatRoomsMaster;
	}

}
