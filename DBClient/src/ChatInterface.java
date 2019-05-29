
import java.rmi.*;

public interface ChatInterface extends Remote {

    public void sendMessage(ChatMessage msg) throws RemoteException;
    
    public void sendRating(ChatMessage msg, String name) throws RemoteException;

    public String update() throws RemoteException;

    public String update(String name) throws RemoteException;
    
    public String update(String name, String ok) throws RemoteException;
    
    public String update(String name, Integer ok) throws RemoteException;

}
