package com.company.gamestore.service;

import com.company.gamestore.model.*;
import com.company.gamestore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {
    private ConsoleRepository consoleRepository;
    private TaxRepository taxRepository;
    private T_ShirtRepository t_shirtRepository;
    private InvoiceRepository invoiceRepository;
    private FeeRepository feeRepository;
    private GameRepository gameRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, TaxRepository taxRepository, T_ShirtRepository t_shirtRepository, InvoiceRepository invoiceRepository, FeeRepository feeRepository, GameRepository gameRepository) {
        this.consoleRepository = consoleRepository;
        this.taxRepository = taxRepository;
        this.t_shirtRepository = t_shirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.feeRepository = feeRepository;
        this.gameRepository = gameRepository;
    }

    // Console API

    public Console saveConsole(Console console) {
        return consoleRepository.save(console);
    }

    public Console findConsoleById(int id) {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public void updateConsole(Console console) {
        consoleRepository.save(console);
    }

    public void deleteConsoleById(int id) {
        consoleRepository.deleteById(id);
    }

    public List<Console> findByManufacturer(String manufacturer) {
        return consoleRepository.findByManufacturer(manufacturer);
    }

    // Game API

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Game findGameById(int id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGameById(int id) {
        gameRepository.deleteById(id);
    }

    public List<Game> findByStudio(String studio) {
        return gameRepository.findByStudio(studio);
    }

    public List<Game> findByEsrbRating(String esrbRating) {
        return gameRepository.findByEsrbRating(esrbRating);
    }

    public List<Game> findByTitle(String title) {
        return gameRepository.findByTitle(title);
    }

    // T_Shirt API

    public T_Shirt saveTShirt(T_Shirt t_shirt) {
        return t_shirtRepository.save(t_shirt);
    }

    public T_Shirt findTShirtById(int id) {
        Optional<T_Shirt> t_shirt = t_shirtRepository.findById(id);
        return t_shirt.isPresent() ? t_shirt.get() : null;
    }

    public List<T_Shirt> findAllTShirts() {
        return t_shirtRepository.findAll();
    }

    public void updateTShirt(T_Shirt t_shirt) {
        t_shirtRepository.save(t_shirt);
    }

    public void deleteTShirtById(int id) {
        t_shirtRepository.deleteById(id);
    }

    public List<T_Shirt> findByColor(String color) {
        return t_shirtRepository.findByColor(color);
    }

    public List<T_Shirt> findBySize(String size) {
        return t_shirtRepository.findBySize(size);
    }

    // Invoice API

    public Invoice saveInvoice(Invoice invoice) {
        if (invoice.getQuantity() < 0) {
            return invoiceRepository.save(invoice);
        }

        BigDecimal subTotal = BigDecimal.valueOf(0);

        if (invoice.getItem_type().equals("Game")) {
            Optional<Game> game = gameRepository.findById(invoice.getItem_id());

            if (game.isPresent() && (invoice.getQuantity() <= game.get().getQuantity())) {
                subTotal = game.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(game.get().getPrice());
            }
            else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        }

        else if (invoice.getItem_type().equals("Console")) {
            Optional<Console> console = consoleRepository.findById(invoice.getItem_id());

            if (console.isPresent() && (invoice.getQuantity() <= console.get().getQuantity())) {
                subTotal = console.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(console.get().getPrice());
            }
            else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(14.99));
        }

        else if (invoice.getItem_type().equals("T-Shirt")) {
            Optional<T_Shirt> t_shirt = t_shirtRepository.findById(invoice.getItem_id());

            if (t_shirt.isPresent() && (invoice.getQuantity() <= t_shirt.get().getQuantity())) {
                subTotal = t_shirt.get().getPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
                invoice.setUnit_price(t_shirt.get().getPrice());
            }
            else {
                return invoiceRepository.save(invoice);
            }

            invoice.setProcessing_fee(BigDecimal.valueOf(1.98));
        }

        invoice.setSubtotal(subTotal);

        // Set tax depending on state
        Tax tax = taxRepository.findByState(invoice.getState());
        invoice.setTax(tax.getRate().multiply(subTotal));

        // Add processing fee if over 10 items
        if (invoice.getQuantity() > 10) {
            invoice.setProcessing_fee(invoice.getProcessing_fee().add(BigDecimal.valueOf(15.49)));
        }

        // Add tax and subTotal for total price
        BigDecimal total = invoice.getSubtotal().add(invoice.getTax().add(invoice.getProcessing_fee()));
        invoice.setTotal(total);

        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(int id) {
        invoiceRepository.deleteById(id);
    }
    public Invoice findInvoiceById(int id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.isPresent() ? invoice.get() : null;
    }

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public List<Invoice> findByName(String name) {
        return invoiceRepository.findByName(name);
    }
}
