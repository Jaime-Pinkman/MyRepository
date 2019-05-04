package ru.itis.models;


import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BasketProduct {
    private Long id;
    private Basket basket;
    private Product product;
}
