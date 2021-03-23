import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class updateChatServant extends UnicastRemoteObject implements updateChat{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected updateChatServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String updateChatLogs(String room, String message) throws RemoteException {
		ApplicationServer.updateChatLogs(message, room);
		
		return "Chats updated sucessfully";
	}

}
