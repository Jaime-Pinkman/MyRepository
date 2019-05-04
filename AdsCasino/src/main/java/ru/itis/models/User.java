package ru.itis.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private String passwordHash;
    private Integer age;
    private Integer xp;
    private Integer index;
}