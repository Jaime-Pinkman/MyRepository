package ru.itis.models;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Basket {
    private Long id;
    private User user;
    private List<Product> products;
}