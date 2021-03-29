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
            System.out.println("Soma: " + resultado);

            resultado = stub.subtracao(200, 3);
            System.out.println("Subtração: " + resultado);
            
            resultado = stub.multiplicacao(200, 3);
            System.out.println("Multiplicação: " + resultado);
            
            float list[] = {2, 4};
            
            float media = stub.media(list);
            
            System.out.println("Média: " + media);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
