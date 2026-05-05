package mk.ukim.finki.wp.lab1b.model.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "auth_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(length = 1000)
    private String token;

    private Date issuedAt;
    private Date expiresAt;

    public AuthLog(String username, String token, Date issuedAt, Date expiresAt) {
        this.username = username;
        this.token = token;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
    }

}