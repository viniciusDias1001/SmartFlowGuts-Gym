package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record MemberResponse(UUID id,
                             UUID gymId,
                             String name,
                             Integer externalCode,
                             Instant createdAt) {
}
