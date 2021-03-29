package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements
		ServiceInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceImpl() throws RemoteException {
		super();
	}
        
	/**
	 *   Métodos remotos
	 */

	public String sayHello(String name) throws RemoteException {
		return "Hello " + name;
	}
	
	public float soma(float a, float b) throws RemoteException {
		return a + b;
	}
        
        public float subtracao( float a, float b) throws RemoteException{
           return a - b; 
        }
        
        public float multiplicacao( float a, float b) throws RemoteException{
            return a * b;
        }
        
        public float media( float list[] ) throws  RemoteException{
            int size = list.length;
            if( size == 0 ){
                return 0;
            }
            float soma = 0;
            float media = 0;
            for (int i = 0; i < size; i++) {
                soma = soma + list[i];
            }
            media = soma / size; 
            return media;
        }
}
