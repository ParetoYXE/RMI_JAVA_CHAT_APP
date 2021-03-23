import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class addNewRoomServant extends UnicastRemoteObject implements addNewRoom{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected addNewRoomServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String echo(String input) throws RemoteException {
		// TODO Auto-generated method stub
		ApplicationServer.updateChatRooms(input);
		return "Added Room: " + input;
		
	}
	
}
