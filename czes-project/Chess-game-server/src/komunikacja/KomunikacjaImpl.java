package komunikacja;

import gra.Gra;
import gra.Gracz;
import gra.Pole;
import gra.Szachownica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KomunikacjaImpl extends UnicastRemoteObject implements Komunikacja {


    public KomunikacjaImpl() throws RemoteException {
        super(); 
    }

	@Override
	public Gracz zaloguj(String name) throws RemoteException {
		int id = Gra.getInstance().getGracze().size() + 1;
		
		Gracz gracz = new Gracz();
		gracz.setId(id);
		gracz.setName(name);
		if(id == 1){
			gracz.setToken(true);
		}
		
		Gra.getInstance().getGracze().add(gracz);
		
		return gracz;
	}

	@Override
	public boolean wykonajRuch(int startX, int startY, int koniecX, int koniecY, int idGracza)
			throws RemoteException {
		return Szachownica.getInstance().zamienPola(startX, startY, koniecX, koniecY, idGracza);
	}

	@Override
	public Gracz pobierzGracza(int id) throws RemoteException {
		if(id - 1 < Gra.getInstance().getGracze().size()){
			return Gra.getInstance().getGracze().get(id - 1);
		}
		else{
			return new Gracz();
		}
	}

	@Override
	public List<Pole> pobierzPola() throws RemoteException {
		return Szachownica.getInstance().pobierzPola();
	}
}
