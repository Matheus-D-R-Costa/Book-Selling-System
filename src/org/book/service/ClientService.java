package org.book.service;

import org.book.model.Client;
import org.book.repository.DatabaseRepository;

import java.util.Optional;

public class ClientService {

    private DatabaseRepository database;

    public ClientService(DatabaseRepository database) {
        this.database = database;
    }

    public Optional<Client> consult(String cpf) {

        if (database.getClient().getCpf().equals(cpf)) {
            return Optional.of(database.getClient());
        } else {
            return Optional.empty();
        }
    }

    public Client loginClient(String cpf) {

        Optional<Client>  result = consult(cpf);

        if (result.isPresent()) {
            Client client = result.get();
            System.out.println(String.format("Olá %s! Você está logado.", client.getName()));
            return client;
        } else {
            System.out.println("Usuário não cadastrado.");
            return null;
        }
    }

    public void registerClient(Client client) {
        database.addClient(client);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void deleteClient(String cpf) {

        Optional<Client> clientToRemove = consult(cpf);

        if (clientToRemove.isPresent()) {
            Client client = clientToRemove.get();
            database.removeClient(client);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente inexistente");
        }
    }
}
