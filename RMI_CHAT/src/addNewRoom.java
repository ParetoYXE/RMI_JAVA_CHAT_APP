import java.rmi.Remote;
import java.rmi.RemoteException;

public interface addNewRoom extends Remote {
	public String echo(String input) throws RemoteException;
	
}
