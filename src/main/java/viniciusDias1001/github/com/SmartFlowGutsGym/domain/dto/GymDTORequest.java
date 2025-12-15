package viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto;


import jakarta.validation.constraints.NotBlank;

public record GymDTORequest(@NotBlank String name,
                            @NotBlank String timezone) {

}
