
import java.rmi.*;
import java.util.ArrayList;

public interface Booking extends Remote {

    public void BookChecker() throws RemoteException;

    public String Confirm() throws RemoteException;
    
    public ArrayList<String> FlightPreview() throws RemoteException;
    
    public void cleanup() throws RemoteException;
    
    public void BookFlight(String flightID,int passengers) throws RemoteException;
}
