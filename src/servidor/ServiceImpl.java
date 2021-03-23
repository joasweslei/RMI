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
        
        public float[][] multMatrix( float a[][], float b[][]) throws RemoteException{
            float soma = 0;
            float resultMatriz [][]= new float[2][2];
            soma = a[0][0] * b[0][0] + a[0][1]* b[1][0]; 
            resultMatriz[0][0] = soma;
            
            soma = a[0][0] * b[0][1] + a[0][1] * b[1][1];
            resultMatriz[0][1] = soma;
            
            soma = a[1][0] * b[0][0] + a[1][1] * b[1][1];
            resultMatriz[1][0] = soma;
            
            soma = a[1][0] * b[0][1] + a[1][1] * b[1][1];
            resultMatriz[1][1] = soma;
            
            return resultMatriz;
        }

}
