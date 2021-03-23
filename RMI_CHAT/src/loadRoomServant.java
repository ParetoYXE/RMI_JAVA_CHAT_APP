import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class loadRoomServant extends UnicastRemoteObject implements LoadRoom {

	protected loadRoomServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> getRoom(String input) throws RemoteException {
		// TODO Auto-generated method stub
		
		return ApplicationServer.getRoom(input);
	}
	

}
