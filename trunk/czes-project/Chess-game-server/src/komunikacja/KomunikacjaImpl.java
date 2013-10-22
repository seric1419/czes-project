package komunikacja;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class KomunikacjaImpl extends UnicastRemoteObject implements Komunikacja {


    public KomunikacjaImpl() throws RemoteException {
        super(); 
    }

    public String obliczStara() throws RemoteException {
        String s = "Gra w szachy";

        return s;
    }
}