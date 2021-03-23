import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class enterServerServant extends UnicastRemoteObject implements enterServer{

	protected enterServerServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String echo(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return "Welcome to the Server: " + input;
	}
	
}
