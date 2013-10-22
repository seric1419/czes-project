import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import komunikacja.Komunikacja;

public class Klient {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out
                    .println("parametry: //host/nazwa");
            System.exit(0);
        }
        String nazwa = args[0];

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        Komunikacja interfejs = null;

        try {
            interfejs = (Komunikacja) Naming.lookup(nazwa);
            String wynik = interfejs.obliczStara();
            System.out.println("Polaczono " + wynik);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
