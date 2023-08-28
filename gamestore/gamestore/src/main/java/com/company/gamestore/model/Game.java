package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;

    @NotEmpty(message = "You must enter a value for title")
    @Size(max = 50, message = "You must enter a value less than 50 characters for title")
    private String title;

    @NotEmpty(message = "You must enter a value for ESRB Rating")
    @Size(max = 50, message = "You must enter a value less than 50 characters for ESRB Rating")
    private String esrb_rating;

    @NotEmpty(message = "You must enter a value for description")
    @Size(max = 255, message = "You must enter a value less than 255 characters for description")
    private String description;

    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @NotEmpty(message = "You must enter a value for studio")
    @Size(max = 50, message = "You must enter a value less than 50 characters for studio")
    private String studio;

    @Min(value = 0, message = "Quantity cannot be negative.")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && quantity == game.quantity && title.equals(game.title) && esrb_rating.equals(game.esrb_rating) && description.equals(game.description) && price.equals(game.price) && studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrb_rating, description, price, studio, quantity);
    }
}
