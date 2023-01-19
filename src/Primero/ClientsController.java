package Primero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientsController {

    private Client[] clients = new Client[4];
    private Client[] clientsLong = new Client[10];
    private Scanner scanner = new Scanner(System.in);

    private int  acc = 0;

    private void reorder(){
        Client[] clients1 = new Client[10];
        int acc = 0;
        for (int i = 0; i < 10; i++) {
            if(!(clientsLong[i] != null)){
                clients1[acc] = clientsLong[i];
                acc++;

            }
        }

        clientsLong = clients1;
    }

    public void add(String name, int id){

        if(acc < 4){
            clients[acc] = new Client(name, id);;
            clientsLong[acc] = new Client(name, id);;
            acc++;
        }else{
            clientsLong[acc] = new Client(name, id);;
        }
         //this.reorder();
    }

    public void deleteByIndex(int index){
        for (int i = 0; i < 10; i++) {
            if(i == index){
                clientsLong[i] = null;
            }
        }
        //this.reorder();
    }

    public void showClients(){
       for(int i = 0; i < 10; i++){
           if(clientsLong[i] != null){
               System.out.println("Cliente número "+ i +": El cliente se llama "+clientsLong[i].getName()+" y su cédula es "+clientsLong[i].getId());
           }

       }
    }

    public void findById(int id){
        for (int i = 0; i < 10; i++) {
            if(clientsLong != null) {
                if (clientsLong[i].getId() == id) {
                    System.out.println("El cliente que se busca está en la posición " + i + ", El cliente se llama " + clientsLong[i].getName() + " y su cédula es " + clientsLong[i].getId());
                }
            }
        }
    }

    public int size(){
        int acc = -1;

        for (int i = 0; i < 10; i++) {
            if(clientsLong == null){
                acc++;
            }
        }

        return acc;
    }

    public ClientsController(){}

}
