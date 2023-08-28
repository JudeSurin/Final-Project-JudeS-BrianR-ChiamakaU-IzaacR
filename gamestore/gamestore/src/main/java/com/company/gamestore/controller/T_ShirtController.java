package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.T_Shirt;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class T_ShirtController {


    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/t_shirts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getTShirtById(@PathVariable int id) {
        return serviceLayer.findTShirtById(id);
    }

    @GetMapping("/tShirts")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllTShirts() {
        return serviceLayer.findAllTShirts();
    }

    @PutMapping("/tShirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody @Valid Invoice t_shirt, @PathVariable int id) {
        serviceLayer.saveTShirt(t_shirt);
    }


    @PostMapping("/tShirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Invoice createTshirt(@RequestBody @Valid T_Shirt tShirt) {
        return serviceLayer.saveTShirt(tShirt);
    }

    @DeleteMapping("/tShirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        serviceLayer.deleteTShirtById(id);
    }

}
