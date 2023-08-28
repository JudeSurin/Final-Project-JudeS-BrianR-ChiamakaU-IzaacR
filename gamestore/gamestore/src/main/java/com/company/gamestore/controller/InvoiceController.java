package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id) {
        return serviceLayer.findInvoiceById(id);
    }

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    @PutMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody @Valid Invoice invoice, @PathVariable int id) {
        serviceLayer.saveInvoice(invoice);
    }


    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice) {
        return serviceLayer.saveInvoice(invoice);
    }

    @DeleteMapping("/invoices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {
        serviceLayer.deleteInvoiceById(id);
    }

    @GetMapping("/invoices/customer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoicesByCustomerName(@PathVariable String name)
    {
        return serviceLayer.findByName(name);
    }
}
