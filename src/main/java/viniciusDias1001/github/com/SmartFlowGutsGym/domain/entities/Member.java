package viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(
        name = "members",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_members_gym_external_code", columnNames = {"gym_id", "external_code"})
        },
        indexes = {
                @Index(name = "idx_members_gym_id", columnList = "gym_id")
        }
)
public class Member {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;


    @Column(name = "external_code", nullable = false)
    private Integer externalCode;

    @NotBlank
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
