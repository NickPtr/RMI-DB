/*Nikos Potaris
  icsd15173*/

import java.rmi.*;

//Interface gia na mporesei o Client na kalesei tis sinartiseis pou exoun ulopoihthei ston Server
public interface Interface extends Remote {

    public void sendMessage(Message msg) throws RemoteException;
    
    public void sendRating(Message msg, String name) throws RemoteException;

    public String update() throws RemoteException;

    public String update(String name) throws RemoteException;
    
    public String update(String name, String ok) throws RemoteException;
    
    public String update(String name, Integer ok) throws RemoteException;

}
