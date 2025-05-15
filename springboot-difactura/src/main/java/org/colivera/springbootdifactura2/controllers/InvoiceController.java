package org.colivera.springbootdifactura2.controllers;

import org.colivera.springbootdifactura2.models.Client;
import org.colivera.springbootdifactura2.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice();
        Client c = new Client();
        c.setLastName(invoice.getCliente().getLastName());
        c.setName(invoice.getCliente().getName());
        i.setCliente(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        return i;
    }
}
