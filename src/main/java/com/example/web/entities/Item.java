package com.example.web.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Item(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "cart_id")
    @JsonBackReference
    private Cart cart;

}
