package viniciusDias1001.github.com.SmartFlowGutsGym.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @RequestBody @Valid UserDTORequest request
    ) {
        return userService.create(request);
    }


    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getById(
            @PathVariable UUID userId
    ) {
        return userService.getById(userId);
    }


    @GetMapping("/by-email")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getByEmail(
            @RequestParam String email
    ) {
        return userService.getByEmail(email);
    }


    @GetMapping("/gym/{gymId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> listByGym(
            @PathVariable UUID gymId
    ) {
        return userService.listAllByGym(gymId);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(
            @PathVariable UUID userId,
            @RequestBody @Valid UserDTORequest request
    ) {
        return userService.update(userId, request);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID userId
    ) {
        userService.delete(userId);
    }
}
