package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbrating")
public class Rating {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private List<Short> ratings = new ArrayList<>();
    @OneToOne
    private Product product;
    private float value;

    public Rating() {
    }

    public Rating(long id, Product product, float value) {
        this.id = id;
        this.product = product;
        this.value = value;
    }

    public void calc() {
        int x = 0;
        for (Short short1 : ratings) {
            x += short1;
        }
        value = x/ratings.size();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<Short> getRatings() {
        return ratings;
    }
    public void setRatings(List<Short> ratings) {
        this.ratings = ratings;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
