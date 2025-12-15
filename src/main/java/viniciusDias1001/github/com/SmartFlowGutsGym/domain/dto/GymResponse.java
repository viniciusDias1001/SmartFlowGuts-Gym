package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record GymResponse(UUID id,
                          String name,
                          String timezone,
                          Instant createdAt) {
}
