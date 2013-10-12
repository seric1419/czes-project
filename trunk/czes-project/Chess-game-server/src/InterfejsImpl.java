
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfejsImpl extends UnicastRemoteObject implements Interfejs {


    public InterfejsImpl() throws RemoteException {
        super(); 
    }

    public String obliczStara() throws RemoteException {
        String s = "Gra w szachy";

        return s;
    }
}