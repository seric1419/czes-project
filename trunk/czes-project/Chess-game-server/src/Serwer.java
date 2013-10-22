import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import komunikacja.KomunikacjaImpl;

public class Serwer {

    public static void main(String[] args) {
        String nazwa = "http://127.0.0.1:1100/serwerek";

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {

            KomunikacjaImpl impl = new KomunikacjaImpl();

            Naming.rebind(nazwa, impl);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Serwer wystartował.");
    }
}