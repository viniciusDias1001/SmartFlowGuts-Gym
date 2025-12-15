package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.Role;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(UUID id,
                           UUID gymId,
                           String name,
                           String email,
                           Role role,
                           Instant createdAt) {
}
