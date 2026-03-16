package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}