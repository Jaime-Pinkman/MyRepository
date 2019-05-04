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
public class Auth {

    private Long id;
    private String cookieValue;
    private User user;
}