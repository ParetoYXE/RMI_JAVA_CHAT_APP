import java.rmi.Remote;
import java.rmi.RemoteException;

public interface updateChat extends Remote {

	public String updateChatLogs(String room, String message) throws RemoteException;
	
} 

