package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import servidor.ServiceInterface;

public class ClienteMain {

    public static void main(String[] args) {

        try {
            int port = 2016;
            String ip = "localhost";
            // Registrar a conexao com o servidor
            Registry registry = LocateRegistry.getRegistry(ip, port);

            // A partir da conexao, obter o objeto stub para executar os metodos remotos
            ServiceInterface stub = (ServiceInterface) registry.lookup("Service_01");
            // stub conhece a lista de metodos implementado no servidor

            // invocao do metodo remoto
            float resultado = stub.soma(200, 3);
            System.out.println("resultado: " + resultado);

            resultado = stub.subtracao(200, 3);
            System.out.println("resultado: " + resultado);
            
            resultado = stub.multiplicacao(200, 3);
            System.out.println("response: " + resultado);
            
            float mat[][] = new float[2][2];
            
            
            mat[0][0] = 2;
            mat[0][1] = 3;
            mat[1][0] = 4;
            mat[1][1] = 5;
            float[][] matriz = stub.multMatrix(mat, mat);
            
            System.out.println("Matriz[0][0]: " + matriz[0][0]);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
