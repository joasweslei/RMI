package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import servidor.ServiceInterface;

public class ClienteMain {

    public static void main(String[] args) {

        try {
            int port = 2016;
            // Registrar a conexao com o servidor
            Registry registry = LocateRegistry.getRegistry("localhost", port);

            // A partir da conexao, obter o objeto stub para executar os metodos remotos
            ServiceInterface stub = (ServiceInterface) registry.lookup("Service_01");
            // stub conhece a lista de metodos implementado no servidor

            // invocao do metodo remoto
            String response = stub.sayHello("Joas ");
            float resultado = stub.soma(200, 3);
            System.out.println("response: " + response);
            System.out.println("response: " + resultado);
            resultado = stub.subtracao(200, 3);
            System.out.println("response: " + resultado);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
