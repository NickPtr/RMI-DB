/*Nikos Potaris
  icsd15173*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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

    //arxikopoiisi tis metablitis "repeats"
    private static int repeats = 0;

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        //enarksi epikoinonias me ton RMI Server
        Interface look_op = (Interface) Naming.lookup("//localhost/RMIServer");
        //kaloume tin "Choise" opou einai h arxiki othoni tou programmatos mas me orismata to "look_op" gia tin epikoinonia me ton RMI Server 
        //kathos kai to "repeats" gia tin katametrisi tou poses fores egine ena rating gia ton swsto upologismo tou mesou orou
        Choise choise = new Choise(look_op, repeats);
        choise.setVisible(true);

    }

}
