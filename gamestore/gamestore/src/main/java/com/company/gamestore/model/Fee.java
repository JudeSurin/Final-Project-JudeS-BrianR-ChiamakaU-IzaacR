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
@Table(name = "fee")
public class Fee implements Serializable {
    @Id
    @NotEmpty(message = "You must enter a value for product type")
    @Size(max = 50, message = "You must enter a value less than 50 characters for product type")
    private String product_type;

    @Column(precision = 8, scale = 2)
    private BigDecimal fee;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee1 = (Fee) o;
        return product_type.equals(fee1.product_type) && fee.equals(fee1.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_type, fee);
    }
}
