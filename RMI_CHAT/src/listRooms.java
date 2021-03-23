import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface listRooms extends Remote {
	public ArrayList<String> listChatRooms(String input) throws RemoteException; 

}
