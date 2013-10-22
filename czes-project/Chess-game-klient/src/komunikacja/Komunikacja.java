package komunikacja;
import gra.Gracz;
import gra.Pole;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Komunikacja extends Remote {

    public Gracz zaloguj(String name) throws RemoteException;
    public boolean wykonajRuch(int startX, int startY, int koniecX, int koniecY, int idGracza) throws RemoteException;
    public Gracz pobierzGracza(int id) throws RemoteException;
    public List<Pole> pobierzPola() throws RemoteException;
}
