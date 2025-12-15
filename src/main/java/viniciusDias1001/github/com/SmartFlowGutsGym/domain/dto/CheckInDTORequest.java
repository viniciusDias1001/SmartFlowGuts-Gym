package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.CheckInSource;

import java.time.Instant;
import java.util.UUID;

public record CheckInDTORequest(@NotNull UUID gymId,
                                @NotBlank String memberExternalCode,
                                Instant occurredAt,
                                @NotNull CheckInSource source) {
}
