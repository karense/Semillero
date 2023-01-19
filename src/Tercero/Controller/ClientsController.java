package Tercero.Controller;



import Tercero.Model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientsController {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client){
        clients.add(client);
    }

    public int getIndexByIdClient(int id){
        System.out.println(clients.stream().filter(client -> client.getId() == id));
        return 0;
    }

    public void showProductsByClient(int id){

    }

    public void deleteByIdClient(int index){
        clients.remove(index);
    }



}
