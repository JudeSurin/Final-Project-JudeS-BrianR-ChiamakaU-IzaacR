package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {
    ServiceLayer service;
    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    InvoiceRepository invoiceRepository;
    T_ShirtRepository t_shirtRepository;
    FeeRepository feeRepository;
    TaxRepository taxRepository;

    @BeforeEach
    public void setUp() throws Exception{
        setUpConsoleRepositoryMock();
        setUpGameRepositoryMock();
        setUpInvoiceRepositoryMock();
        setUpT_ShirtRepositoryMock();

        service = new ServiceLayer(consoleRepository,taxRepository,t_shirtRepository,invoiceRepository,feeRepository,gameRepository);
    }

    private void setUpConsoleRepositoryMock(){
        consoleRepository = mock(ConsoleRepository.class);
        Console console = new Console();
        console.setId(1);
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);

        Console console2 = new Console();
        console2.setModel("Ps5");
        console2.setManufacturer("sony");
        console2.setMemory_amount("825GB");
        console2.setProcessor("AMD Zen 2 CPU");
        console2.setPrice(BigDecimal.valueOf(500));
        console2.setQuantity(1);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        doReturn(console).when(consoleRepository).save(console2);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(consoleList).when(consoleRepository).findAll();

    }

    private void setUpGameRepositoryMock(){
        gameRepository = mock(GameRepository.class);
        Game game = new Game();
        game.setId(1);
        game.setTitle("God of war");
        game.setEsrbRating("Pegi 18");
        game.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game.setPrice(new BigDecimal(60.00));
        game.setStudio("Santa Monica Studio");
        game.setQuantity(1);

        Game game2 = new Game();
        game2.setTitle("God of war");
        game2.setEsrbRating("Pegi 18");
        game2.setDescription("Former greek god of war tries his best to raise and protect his son, however, his son wants to know who he truly is.");
        game2.setPrice(new BigDecimal(60.00));
        game2.setStudio("Santa Monica Studio");
        game2.setQuantity(1);


        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameRepository).save(game2);
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(gameList).when(gameRepository).findAll();

    }

    private void setUpInvoiceRepositoryMock(){
        invoiceRepository = mock(InvoiceRepository.class);
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("Izaac Ramirez");
        invoice.setState("Elmcroft Ave");
        invoice.setCity("Norwalk");
        invoice.setState("CA");
        invoice.setZipcode("90650");
        invoice.setItem_type("Game");
        invoice.setItem_id(562);
        invoice.setUnit_price(new BigDecimal(0.62));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal(60.00));
        invoice.setTax(new BigDecimal(0.72));
        invoice.setProcessing_fee(new BigDecimal(1.20));
        invoice.setTotal(new BigDecimal(62.54));

        Invoice invoice2 = new Invoice();
        invoice2.setName("Izaac Ramirez");
        invoice2.setState("Elmcroft Ave");
        invoice2.setCity("Norwalk");
        invoice2.setState("CA");
        invoice2.setZipcode("90650");
        invoice2.setItem_type("Game");
        invoice2.setItem_id(562);
        invoice2.setUnit_price(new BigDecimal(0.62));
        invoice2.setQuantity(1);
        invoice2.setSubtotal(new BigDecimal(60.00));
        invoice2.setTax(new BigDecimal(0.72));
        invoice2.setProcessing_fee(new BigDecimal(1.20));
        invoice2.setTotal(new BigDecimal(62.54));

        List<Invoice> invoiceList =  new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceRepository).save(invoice2);
        doReturn(Optional.of(invoice)).when(invoiceRepository).findById(1);
        doReturn(invoiceList).when(invoiceRepository).findAll();

    }

    private void setUpT_ShirtRepositoryMock(){
        T_Shirt TShirt = new T_Shirt();
        TShirt.setId(1);
        TShirt.setSize("XL");
        TShirt.setColor("Black");
        TShirt.setDescription("Black tshirt with naruto on it");
        TShirt.setPrice(new BigDecimal(30.00));
        TShirt.setQuantity(2);

        T_Shirt TShirt2 = new T_Shirt();
        TShirt2.setSize("XL");
        TShirt2.setColor("Black");
        TShirt2.setDescription("Black tshirt with naruto on it");
        TShirt2.setPrice(new BigDecimal(30.00));
        TShirt2.setQuantity(2);

        List<T_Shirt> tShirtList =  new ArrayList<>();
        tShirtList.add(TShirt);

        doReturn(TShirt).when(t_shirtRepository).save(TShirt2);
        doReturn(Optional.of(TShirt)).when(t_shirtRepository).findById(1);
        doReturn(tShirtList).when(t_shirtRepository).findAll();
    }

    @Test
    public void shouldSaveConsole(){

        Console expectedConsole = new Console();
        expectedConsole.setId(1);
        expectedConsole.setModel("Ps5");
        expectedConsole.setManufacturer("sony");
        expectedConsole.setMemory_amount("825GB");
        expectedConsole.setProcessor("AMD Zen 2 CPU");
        expectedConsole.setPrice(BigDecimal.valueOf(500));
        expectedConsole.setQuantity(1);

        Console console = new Console();
        console.setModel("Ps5");
        console.setManufacturer("sony");
        console.setMemory_amount("825GB");
        console.setProcessor("AMD Zen 2 CPU");
        console.setPrice(BigDecimal.valueOf(500));
        console.setQuantity(1);


        Console savedConsole = service.saveConsole(console);

        assertEquals(expectedConsole, savedConsole);
    }

}
