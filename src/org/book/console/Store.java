package org.book.console;

import org.book.model.Client;
import org.book.repository.DatabaseRepository;
import org.book.service.ClientService;
import org.book.service.OrderService;
import org.book.service.ProductService;
import org.book.util.DataReaderUtil;

public class Store {

    private static Client loggedClient = null;

    private static DatabaseRepository database = new DatabaseRepository();

    private static ClientService clientService = new ClientService(database);
    private static OrderService orderService = new OrderService(database);
    private static ProductService productService = new ProductService(database);

    public static void main(String[] args) {

        System.out.println("Bem-vindo(a) as compras!");

        String option = "";

        while(true) {

            if(loggedClient == null) {

                System.out.println("Digite seu CPF"); {

                    String cpf = "";
                    cpf = DataReaderUtil.readData();


                }
            }

        }
    }

    private static void identifyUser(String cpf) {
        //TODO FINALIZAR O MÉTODO IDENTIFYUSER
    }
}
