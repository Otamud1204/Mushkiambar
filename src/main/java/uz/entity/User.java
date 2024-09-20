package uz.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer age;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String rol;

}



