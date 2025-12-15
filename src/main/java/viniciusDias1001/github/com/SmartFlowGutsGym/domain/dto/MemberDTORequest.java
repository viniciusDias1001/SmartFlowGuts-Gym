package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MemberDTORequest(@NotNull UUID gymId,
                               @NotBlank String externalCode,
                               @NotBlank String name) {
}
