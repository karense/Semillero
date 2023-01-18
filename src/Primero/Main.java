package Primero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientsController clientsController = new ClientsController();
        boolean isExit = false;

        while (!isExit) {

            System.out.println("a. Añadir nuevo cliente");
            System.out.println("b. Borrar un cliente");
            System.out.println("c. Buscar un cliente");
            System.out.println("d. Mostrar los clientes");
            System.out.println("e. Salir.");
            System.out.println("Escribe una de las opciones");

            String option = scanner.next();

            switch (option) {
                case "a":
                    boolean isClientsListSmallerThanThen = clientsController.size() < 10;
                    if (isClientsListSmallerThanThen) {
                        clientsController.add();
                    } else {
                        System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo");
                    }
                    break;
                case "b":
                    clientsController.deleteByIndex();
                    break;
                case "c":
                    clientsController.findById();
                    break;
                case "d":
                    clientsController.showClients();
                    break;
                case "e":
                    isExit = true;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }

        }

    }
}
