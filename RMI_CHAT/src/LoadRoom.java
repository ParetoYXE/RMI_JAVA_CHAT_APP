import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LoadRoom extends Remote {

	public ArrayList<String> getRoom(String input) throws RemoteException;
	
}
