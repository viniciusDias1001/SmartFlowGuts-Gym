package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.CheckInSource;

import java.time.Instant;
import java.util.UUID;

public record CheckInResponse(UUID id,
                              UUID gymId,
                              UUID memberId,
                              Instant occurredAt,
                              CheckInSource source) {
}
