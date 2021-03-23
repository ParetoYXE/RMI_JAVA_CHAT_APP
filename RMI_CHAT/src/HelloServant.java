import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServant extends UnicastRemoteObject implements HelloService {

	protected HelloServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String echo(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return "Server says: Hello " + input;
	}
	
	
	

}
