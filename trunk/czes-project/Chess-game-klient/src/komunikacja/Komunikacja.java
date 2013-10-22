package komunikacja;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Komunikacja extends Remote {

    public String obliczStara() throws RemoteException;
}