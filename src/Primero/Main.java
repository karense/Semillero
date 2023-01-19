package Primero;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    int id;
                    boolean isClientsListSmallerThanThen = clientsController.size() != 0;
                    if (isClientsListSmallerThanThen) {
                        System.out.println("Escribe el nombre");
                        String name = scanner.next();

                        if(!(name.matches("[aA-zZ]+"))){
                            System.out.println("Debe ser solo letras");
                            break;
                        }
                        System.out.println("Escribe la cédula");
                        try {
                            id = scanner.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ser un número");
                            break;
                        }
                        clientsController.add(name, id);
                    } else {
                        System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo");
                    }
                    break;
                case "b":
                    System.out.println("Escribe el index del cliente a eliminar");
                    int index = scanner.nextInt();
                    clientsController.deleteByIndex(index);
                    break;
                case "c":
                    System.out.println("Ingrese la cédula");
                    int idInput = scanner.nextInt();
                    clientsController.findById(idInput);
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

        scanner.close();

    }
}
