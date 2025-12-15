package viniciusDias1001.github.com.SmartFlowGutsGym.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.service.GymServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gyms")
@RequiredArgsConstructor
public class GymController {
    private final GymServiceImpl gymService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public GymResponse createNewGym(@RequestBody @Valid GymDTORequest gymDTORequest){
        return gymService.create(gymDTORequest);

    }

    @GetMapping("/{gymId}")
    @ResponseStatus(HttpStatus.OK)
    public GymResponse getGymById(@PathVariable UUID gymId){
       return gymService.getById(gymId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GymResponse> listAll() {
        return gymService.listAll();
    }

    @PutMapping("/{gymId}")
    @ResponseStatus(HttpStatus.OK)
    public GymResponse update(
            @PathVariable UUID gymId,
            @RequestBody @Valid GymDTORequest request
    ) {
        return gymService.update(gymId, request);
    }

    @DeleteMapping("/{gymId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID gymId) {
        gymService.delete(gymId);
    }



}
