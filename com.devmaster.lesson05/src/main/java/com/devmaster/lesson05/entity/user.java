package com.devmaster.lesson05.entity;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class user {
    String name;
    String username;
    String password;
    String email;
}
