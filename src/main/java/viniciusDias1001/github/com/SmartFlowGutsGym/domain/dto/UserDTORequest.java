package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.enums.Role;

import java.util.UUID;

public record UserDTORequest(@NotNull UUID gymId,
                             @NotBlank String name,
                             @Email @NotBlank String email,
                             @NotBlank String password,
                             @NotNull Role role) {
}
