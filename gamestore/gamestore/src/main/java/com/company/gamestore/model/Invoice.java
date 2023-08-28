package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @NotEmpty(message = "You must enter a value for name")
    @Size(max = 50, message = "You must enter a value less than 50 characters for name")
    private String name;

    @NotEmpty(message = "You must enter a value for street")
    @Size(max = 100, message = "You must enter a value less than 100 characters for street")
    private String street;

    @NotEmpty(message = "You must enter a value for city")
    @Size(max = 50, message = "You must enter a value less than 50 characters for city")
    private String city;

    @NotEmpty(message = "You must enter a value for state")
    @Size(max = 20, message = "You must enter a value less than 20 characters for state")
    private String state;

    @NotEmpty(message = "You must enter a value for zipcode")
    @Size(min = 10, max = 10, message = "You must enter a value with exactly 10 digits for zipcode")
    private String zipcode;

    @NotEmpty(message = "You must enter a value for item type")
    @Size(max = 50, message = "You must enter a value less than 50 characters for item type")
    private String item_type;

    @NotEmpty(message = "You must enter a value for item id")
    private int item_id;

    @Column(precision = 8, scale = 2)
    private BigDecimal unit_price;

    @NotEmpty(message = "You must enter a value for quantity")
    private int quantity;

    @Column(precision = 8, scale = 2)
    private BigDecimal subtotal;

    @Column(precision = 8, scale = 2)
    private BigDecimal tax;

    @Column(precision = 8, scale = 2)
    private BigDecimal processing_fee;

    @Column(precision = 8, scale = 2)
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && item_id == invoice.item_id && quantity == invoice.quantity && name.equals(invoice.name) && street.equals(invoice.street) && city.equals(invoice.city) && state.equals(invoice.state) && zipcode.equals(invoice.zipcode) && item_type.equals(invoice.item_type) && unit_price.equals(invoice.unit_price) && subtotal.equals(invoice.subtotal) && tax.equals(invoice.tax) && processing_fee.equals(invoice.processing_fee) && total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total);
    }
}
