package Segundo;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientsController {
    private List<Client> clients = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);



    private boolean isNameValid(String name){
        return name.matches("[Aa-zZ]+");
    }

    private boolean isValidId(int id){
        boolean acc = true;
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId() == id){
                acc = false;
            }
        }
        return acc;
    }
    public void add(String name, int id){
        Client client = new Client(name, id);
        if(isValidId(id)) {
            clients.add(client);
        }else{
            System.out.println("El cliente ya existe con estas cédula.");
        }

    }

    public void deleteByIndex(int index){
        clients.remove(index);
    }

    public void showClients(){

        clients.forEach((client) -> {
            System.out.println("Cliente número " + 1 + ": El cliente se llama " + client.getName() + " y su cédula es " + client.getId());
        });

    }

    public void deleteById(int id){
        int index = findById(id);

        if(index > 0){
            clients.remove(index);
            System.out.println("EL cliente con cédula "+id+" se ha borrado exitosamente.");
        }

    }

    public int findById(int id){

        Client clientFilted = new Client();
        int indexSelected = -1;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                clientFilted.setId(clients.get(i).getId());
                clientFilted.setName(clients.get(i).getName());
                indexSelected = i;
            }

        }

        if(indexSelected > 0){
            System.out.println("El cliente que se busca está en la posición "+ indexSelected +", El cliente se llama "+clientFilted.getName()+" y su cédula es "+clientFilted.getId());
        }else{
            System.out.println("No existe ningun cliente asociado a ese número de cédula");
        }

        return indexSelected;
    }

    public int size(){
        return clients.size();
    }

    public ClientsController(){}

}
