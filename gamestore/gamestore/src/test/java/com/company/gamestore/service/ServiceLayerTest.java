package com.company.gamestore.service;

import com.company.gamestore.repository.*;
import org.junit.jupiter.api.BeforeEach;

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
        
    }

    private void setUpGameRepositoryMock(){

    }

    private void setUpInvoiceRepositoryMock(){

    }

    private void setUpT_ShirtRepositoryMock(){

    }

}
