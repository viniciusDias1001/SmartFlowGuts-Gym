package viniciusDias1001.github.com.SmartFlowGutsGym.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.Gym;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.User;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.BadRequestException;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.BusinessException;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.ResourceNotFoundException;
import viniciusDias1001.github.com.SmartFlowGutsGym.repository.GymRepository;
import viniciusDias1001.github.com.SmartFlowGutsGym.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository;
    private final GymRepository gymRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(UserDTORequest request) {
        String email = request.email().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("Email already exists");
        }

        Gym gym = gymRepository.findById(request.gymId())
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found: " + request.gymId()));

        User user = new User();
        user.setGym(gym);
        user.setName(request.name().trim());
        user.setEmail(email);
        user.setRole(request.role()); // (Enum Role)
        String passwordHash = passwordEncoder.encode(request.password());
        user.setPasswordHash(passwordHash);
        user.setCreatedAt(Instant.now());

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    @Override
    @Transactional()
    public UserResponse getById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        return toResponse(user);
    }

    @Override
    @Transactional()
    public UserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email.trim().toLowerCase())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return toResponse(user);
    }

    @Override
    @Transactional()
    public List<UserResponse> listAllByGym(UUID gymId) {
        if (!gymRepository.existsById(gymId)) {
            throw new ResourceNotFoundException("Gym not found: " + gymId);
        }

        return userRepository.findAllByGymId(gymId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponse update(UUID userId, UserDTORequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

        // Se permitir trocar de gym (normalmente NÃO), você muda aqui.
        if (!user.getGym().getId().equals(request.gymId())) {
            throw new BadRequestException("You cannot change the gym of an existing user");
        }

        String newEmail = request.email().trim().toLowerCase();
        if (!user.getEmail().equalsIgnoreCase(newEmail) && userRepository.existsByEmail(newEmail)) {
            throw new BusinessException("Email already exists");
        }

        user.setName(request.name().trim());
        user.setEmail(newEmail);
        user.setRole(request.role());

        if (request.password() != null && !request.password().isBlank()) {
            user.setPasswordHash(passwordEncoder.encode(request.password()));
        }

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    @Override
    public void delete(UUID userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found: " + userId);
        }
        userRepository.deleteById(userId);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getGym().getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

}
