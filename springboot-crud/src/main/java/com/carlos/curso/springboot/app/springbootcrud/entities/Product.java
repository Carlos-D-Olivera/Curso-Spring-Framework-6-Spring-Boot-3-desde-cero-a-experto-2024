package com.carlos.curso.springboot.app.springbootcrud.entities;

import com.carlos.curso.springboot.app.springbootcrud.validation.IsExistDb;
import com.carlos.curso.springboot.app.springbootcrud.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
//import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsExistDb
    @IsRequired
    private String sku;

//    @NotEmpty(message = "{NotEmpty.product.name}")
    @IsRequired(message = "{IsRequired.product.name}")
    @Size(min=3, max=20)
    private String name;

    @Min(value = 500, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

//    @NotBlank(message = "{NotBlank.product.description}")
    @IsRequired
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
