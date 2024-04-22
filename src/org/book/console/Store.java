package org.book.console;

import org.book.model.Book;
import org.book.model.Client;
import org.book.model.Coupon;
import org.book.model.Order;
import org.book.repository.DatabaseRepository;
import org.book.service.ClientService;
import org.book.service.OrderService;
import org.book.service.ProductService;
import org.book.util.DataReaderUtil;

import java.util.Optional;

public class Store {

    private static Client loggedClient = null;

    private static final DatabaseRepository database = new DatabaseRepository();

    private static final ClientService clientService = new ClientService(database);
    private static final OrderService orderService = new OrderService(database);
    private static final ProductService productService = new ProductService(database);

    public static void main(String[] args) {

        System.out.println("Bem-vindo(a) as compras!");

        String option = "";

        while (true) {

            if (loggedClient == null) {

                System.out.println("Digite seu CPF");

                String cpf = "";
                cpf = DataReaderUtil.readData();

                identifyUser(cpf);

            }

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            //TODO Desafio: Consultar Livro(nome)
            System.out.println("3 - Cadastrar Caderno");
            System.out.println("4 - Excluir Caderno");
            //TODO Desafio: Consultar Caderno(matéria)
            System.out.println("5 - Fazer pedido");
            System.out.println("6 - Excluir pedido");
            //TODO Desafio: Consultar Pedido(código)
            System.out.println("7 - Listar produtos");
            System.out.println("8 - Listar pedidos");
            System.out.println("9 - Deslogar");
            System.out.println("10 - Sair");

            option = DataReaderUtil.readData();

            switch (option) {
                case "1":
                    Book book = DataReaderUtil.readBook();
                    productService.save(book);
                    break;
                case "2":
                    System.out.println("Digite o código do livro");
                    String idBook = DataReaderUtil.readData();
                    productService.delete(idBook);
                case "3":
                    //TODO Cadastrar Caderno
                    break;
                case "4":
                    //TODO Excluir Caderno
                    break;
                case "5":
                    Order order = DataReaderUtil.readOrder(database);
                    Optional<Coupon> coupon = DataReaderUtil.readCoupon(database);

                    if (coupon.isPresent()) {
                        orderService.save(order, coupon.get());
                    } else {
                        orderService.save(order);
                    }
                    break;
                case "6":
                    System.out.println("Digite o código do pedido");
                    String idPedido = DataReaderUtil.readData();
                    orderService.delete(idPedido);
                    break;
                case "7":
                    productService.showAll();
                    break;
                case "8":
                    orderService.showAll();
                    break;
                case "9":
                    System.out.println(String.format("Volte sempre %s!", loggedClient.getName()));
                    loggedClient = null;
                    break;
                case "10":
                    System.out.println("Aplcação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void identifyUser(String cpf) {

        Optional<Client> result = clientService.consult(cpf);

        if (result.isPresent()) {

            Client client = result.get();
            System.out.println(String.format("Olá %s! Você está logado com sucesso!", client.getName()));
            loggedClient = client;
        } else {
            System.out.println("Cliente não encontrado!");
            System.exit(0);
        }
    }
}
