package com.munira.reactive.model;

import lombok.*;

import java.util.UUID;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    UUID id;
    String name;
    String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
