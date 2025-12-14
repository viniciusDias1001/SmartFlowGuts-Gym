package viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.CheckInSource;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "checkins",
        indexes = {
                @Index(name = "idx_checkins_gym_occurred_at", columnList = "gym_id, occurred_at"),
                @Index(name = "idx_checkins_member_occurred_at", columnList = "member_id, occurred_at")
        }
)
@Getter
@Setter
public class CheckIn {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CheckInSource source;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
}
