package Primero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientsController {

    private List<Client> clients = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public void add(){
        System.out.println("Escribe el nombre");
        String name = scanner.next();
        System.out.println("Escribe la cédula");
        int id = scanner.nextInt();
        Client newClient = new Client(name, id);
        //clients();
    }

    public void deleteByIndex(){
        System.out.println("Escribe el index del cliente a eliminar");
        int index = scanner.nextInt();
        clients.remove(index);
    }

    public void showClients(){
        clients.forEach((client) -> System.out.println("Cliente número "+ 1 +": El cliente se llama "+client.getName()+" y su cédula es "+client.getId()));
    }

    public void findById(){
        System.out.println("Ingrese la cédula");
        int id = scanner.nextInt();
        Client clientFilted = new Client();
        clients.forEach((client) -> {
            if(client.getId()== id){
                clientFilted.setId(client.getId());
                clientFilted.setName(client.getName());
            }

        });
        System.out.println("El cliente que se busca está en la posición 0, El cliente se llama "+clientFilted.getName()+" y su cédula es "+clientFilted.getId());
    }

    public int size(){
        return clients.size();
    }

    public ClientsController(){}

}
