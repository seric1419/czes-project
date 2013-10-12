import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfejs extends Remote {

    public String obliczStara() throws RemoteException;
}