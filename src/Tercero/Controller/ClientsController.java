package Tercero.Controller;



import Tercero.Model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientsController {
    private List<Client> clients = new ArrayList<>();

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
    public void addClient(String name, int id ){
        Client client = new Client(name, id);
        if(isValidId(id)) {
            clients.add(client);
        }else{
            System.out.println("El cliente ya existe con estas cédula.");
        }
    }

    public int getIndexByIdClient(int id){
        Client clientFilted = new Client();
        int indexSelected = -1;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                clientFilted.setId(clients.get(i).getId());
                clientFilted.setName(clients.get(i).getName());
                indexSelected = i;
            }

        }

        if(indexSelected < 0){
            System.out.println("No existe ningun cliente asociado a ese número de cédula");
        }

        return indexSelected;
    }

    public void findByIdClient(int id){
        int index = getIndexByIdClient(id);
        System.out.println("El cliente "+clients.get(index).getName()+"identificado con cédula "+clients.get(index).getId());
        System.out.println("Productos: ");
        showProductsByClient(id);
    }

    public void showProductsByClient(int id){
        int index = getIndexByIdClient(id);
        try{
            clients.get(index).getProducts().forEach(product -> System.out.println(product.getName()+ " con una cantidad de x valor unitario: "+product.getPrice()));
        }catch (NullPointerException  e){
            System.out.println("No hay productos");
        }

    }

    public void showClients(){
        clients.forEach(client-> {
            findByIdClient(client.getId());
        });
    }

    public void deleteByIdClient(int id){
        int index = getIndexByIdClient(id);
        if(index > 0){
            clients.remove(index);
            System.out.println("EL cliente con cédula "+id+" se ha borrado exitosamente.");
        }
    }

    public int size(){
        return clients.size();
    }


}
