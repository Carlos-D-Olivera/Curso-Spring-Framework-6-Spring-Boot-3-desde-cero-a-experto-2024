package com.carlos.curso.springboot.jpa.springbootjparelationships.repositories;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
