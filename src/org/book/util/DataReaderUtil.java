package org.book.util;

import org.book.model.*;
import org.book.model.enums.Gender;
import org.book.model.enums.Material;
import org.book.repository.DatabaseRepository;
import org.book.service.ClientService;
import org.book.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public final class DataReaderUtil {

    private static Scanner scanner;

    static  {
        scanner = new Scanner(System.in);
    }

    public static Book readBook() {
        System.out.println("Cadastrando livro...");
        Book book = readBookName();

        System.out.println("Digite o gênero: drama, suspense, romance");
        String gender = readData();
        book.setGender(Gender.valueOf(gender.toUpperCase()));

        System.out.println("Digite o preço (padrão 0.0)");
        String price = readData();
        book.setPrice(Double.parseDouble(price));

        return book;
    }

    private static Book readBookName() {
        Book book = new Book();

        System.out.println("Digite o nome do livro");
        String name = readData();
        book.setName(name);

        return book;
    }

    public static Notebook readNotebook() {
        System.out.println("Cadastrando caderno...");
        Notebook notebook = readNotebookType();

        System.out.println("Digite o preço (padrão 0.0)");
        String price = readData();
        notebook.setPrice(Double.parseDouble(price));

        return notebook;
    }

    private static Notebook readNotebookType() {
        Notebook notebook = new Notebook();

        System.out.println("Digite o tipo do caderno");
        System.out.println("M2 - 2 matérias");
        System.out.println("M5 - 5 matérias");
        System.out.println("M10 - 10 matérias");
        String type = readData();
        notebook.setType(Material.valueOf(type.toUpperCase()));

        return notebook;
    }



    public static Order readOrder(DatabaseRepository database) {
        ProductService productService = new ProductService(database);

        System.out.println("Cadastrakndo pedido...");
        Order order = new Order();

        String option = "s";

        do {

            System.out.println("Digite o código do produto (Livro/Caderno)");
            String id = readData();

            Optional<Product> result = productService.consult(id);

            if(result.isPresent()) {
                Product product = result.get();

                System.out.println("Digite a quantidade");
                String quantity = readData();
                product.setQuantity(Integer.parseInt(quantity));

                order.getProducts().add(product);

            } else {
                System.out.println("Produto inexistente. Escolha um produto válido");
            }

            System.out.println("Deseja selecionar mais um produto (S/N)");
            option = readData();

        } while ("s".equals(option));

        return order;
    }

    public static Optional<Coupon> readCoupon(DatabaseRepository database) {
        System.out.println("Caso queira utilizar algum cupom escolha entre: CUPOM2, CUPOM5, CUPOM10. Se não desejar, deixe em branco");

        String discount = readData();

        for (Coupon coupon : database.getCoupons()) {

            if (coupon.getId().equalsIgnoreCase(discount)) {
                return Optional.of(coupon);
            }
        }

        return Optional.empty();
    }

    public static Client readClient(String cpf) {

        System.out.println("Cadastrando cliente...");
        Client client = new Client();

        System.out.println("Digite o nome");
        String name = readData();
        client.setName(name);

        client.setCpf(cpf);

        return client;
    }

    public static String readData() {
        String text = scanner.nextLine();
        return text;
    }

}
