package viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.Role;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users", indexes = {
        @Index(name = "idx_users_gym_id", columnList = "gym_id"),
        @Index(name = "uk_users_email", columnList = "email", unique = true)})
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @NotBlank
    private String name;

    @Email
    @Column(nullable = false, unique = true, length = 150)
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
