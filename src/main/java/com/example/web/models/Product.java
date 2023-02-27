package com.example.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("Product")
public class Product implements Serializable {
    private static final long serialVersionUID = -6710998045727749532L;
    @Id
    private int id;
    private String name;
    private int qty;
    private Long price;
}
