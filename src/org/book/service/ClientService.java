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

    //TODO Fazer a inclusão de cliente

    //TODO Fazer a exclusão de cliente
}
