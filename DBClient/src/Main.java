
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static int repeats=0;
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ChatInterface look_op = (ChatInterface) Naming.lookup("//localhost/RMIServer");
                
               
                Choise choise = new Choise(look_op,repeats);
                choise.setVisible(true);

                }
    
    }
    

