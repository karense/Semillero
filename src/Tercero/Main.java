package Tercero;

import Tercero.Controller.ClientsController;
import Tercero.Model.Client;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Client> clients = new ArrayList<>();
        Client newClient = new Client("hola", 12);
        clients.add(newClient);
        System.out.println(clients.stream().filter(client -> client.getId() == 12));
    }
}
