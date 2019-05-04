package ru.itis.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Product {
    private Long id;
    private Long product_id;
    private String title;
    private Long xp;
    private String image;
    private Long price;
}
