package viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "gyms")
@Getter
@Setter
public class Gym {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Column(name = "timezone", nullable = false, length = 60)
    private String timezone;

    @Column
    @NotNull
    @NotEmpty
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}
