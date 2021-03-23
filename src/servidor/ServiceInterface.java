package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {

    String sayHello(String name) throws RemoteException;

    float soma(float a, float b) throws RemoteException;
    
    float subtracao( float a, float b) throws RemoteException;

}