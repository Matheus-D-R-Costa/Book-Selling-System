package org.book.util;

import org.book.model.Book;
import org.book.model.Coupon;
import org.book.model.Order;
import org.book.model.Product;
import org.book.model.enums.Gender;
import org.book.repository.DatabaseRepository;
import org.book.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public final class DataReaderUtil {

    private static Scanner scanner;

    static  {
        scanner = new Scanner(System.in);
    }

    public static String readData() {
        String text = scanner.nextLine();
        return text;
    }

    public static Book readBook() {
        System.out.println("Cadastrando livro...");
        Book book = new Book();

        System.out.println("Digite o nome");
        String name = readData();
        book.setName(name);

        System.out.println("Digite o gênero: DRAMA, SUSPENSE, ROMANCE");
        String gender = readData();
        book.setGender(Gender.valueOf(gender.toUpperCase()));

        return book;
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
}
