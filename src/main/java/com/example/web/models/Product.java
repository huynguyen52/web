package com.example.web.models;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int qty;
    private Long price;

}
