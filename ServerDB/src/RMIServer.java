/*Nikos Potaris
  icsd15173*/

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer extends UnicastRemoteObject implements Interface {

    private Statement stat;
    int rate=0,repeats=0;

    //enarksi epikoinwnias, kathos kai ulopoihsi gia tin dimiourgia pinaka sto Data Base 
    public RMIServer() throws RemoteException {
        super();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:chat.db");
            stat = conn.createStatement();
            System.out.println("Database connection established");
            stat.executeUpdate("DROP table if exists messages;");
            stat.executeUpdate("CREATE table messages (title varchar(50),type varchar(50),singer varchar(200),time varchar(50),rating varchar(50),repeats varchar(50));");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //sinartisi gia tin kataxorisi dedomenwn sto Data Base mas stis kataliles theseis (title, type, singer, time, rating, repeats)
    public void sendMessage(Message msg) throws RemoteException {
        try {
            String message = "INSERT INTO messages (title, type, singer, time, rating, repeats) VALUES('" + msg.getTitle() + "'  ,'" + msg.getType() + "'  ,'" + msg.getSinger() + "'  ,'" + msg.getTime() + "'  ,'" + rate + "'  ,'" + msg.getRepeats() + "')";
            System.out.println("Query executed : " + message);
            stat.executeUpdate(message);
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //sinartisei gia tin kataxorisei tou Rating sto Data Base
    public void sendRating(Message msg, String name) throws RemoteException {
        try {
            repeats=msg.getRepeats();
            rate=(rate+msg.getRating())/repeats;
            
            System.out.println(rate+"\t"+repeats);
            String message = "UPDATE messages SET rating = " + rate + " WHERE title='"+ name + "'";
            System.out.println("Query executed : " + message);
            stat.executeUpdate(message);
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //sinartisi gia tin epistrofi olou tou pinaka tou Data Base
    public String update() throws RemoteException {
        ResultSet records = null;
        try {
            records = stat.executeQuery("SELECT * from messages");
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tilte, type, singer, time;
        int rating;
        String str = "";
        try {
            while (records.next()) {
                tilte= records.getString("title");
                type = records.getString("type");
                singer = records.getString("singer");
                time = records.getString("time");
                rating = records.getInt("rating");
                
                str = str + tilte + "\t" + type + "\t" + singer + "\t" + time + "\t" + rating +"\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    //sinartisei gia tin epistrofi apo to Data Base ton katagrafwn me to rating pou exei zitithei apo ton xristi
    public String update(String name, Integer ok) throws RemoteException {
        ResultSet records = null;
        try {
            records = stat.executeQuery("SELECT * from messages WHERE rating='"+ ok + "'");
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tilte, type, singer, time;
        int rating;
        String str = "";
        try {
            while (records.next()) {
                tilte= records.getString("title");
                type = records.getString("type");
                singer = records.getString("singer");
                time = records.getString("time");
                rating = records.getInt("rating");
                
                str = str + tilte + "\t" + type + "\t" + singer + "\t" + time + "\t" + rating +"\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    //sinartisei gia tin epistrofi apo to Data Base ton katagrafwn me ton titlo pou exei zitithei apo ton xristi
    public String update(String name) throws RemoteException {
        ResultSet records = null;
        try {
            records = stat.executeQuery("SELECT * from messages WHERE title='"+ name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tilte, type, singer, time;
        int rating;
        String str = "";
        try {
            while (records.next()) {
                tilte= records.getString("title");
                type = records.getString("type");
                singer = records.getString("singer");
                time = records.getString("time");
                rating = records.getInt("rating");
                
                str = str + tilte + "\t" + type + "\t" + singer + "\t" + time + "\t"+ rating +"\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    //sinartisei gia tin epistrofi apo to Data Base ton katagrafwn me ton tragoudisti pou exei zitithei apo ton xristi
    public String update(String name, String ok) throws RemoteException {
        ResultSet records = null;
        try {
            records = stat.executeQuery("SELECT * from messages WHERE singer='"+ name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tilte, type, singer, time;
        int rating;
        String str = "";
        try {
            while (records.next()) {
                tilte= records.getString("title");
                type = records.getString("type");
                singer = records.getString("singer");
                time = records.getString("time");
                rating = records.getInt("rating");
                
                str = str + tilte + "\t" + type + "\t" + singer + "\t" + time + "\t" + rating +"\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    //enarksi epikoinonias me ton Client
    public static void main(String[] args) {

        RMIServer server;
        try {
            server = new RMIServer();
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/RMIServer", server);
            System.out.println("Waiting new Messages");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

}
