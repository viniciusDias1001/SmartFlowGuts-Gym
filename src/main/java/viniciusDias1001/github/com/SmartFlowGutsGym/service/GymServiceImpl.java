package viniciusDias1001.github.com.SmartFlowGutsGym.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.Gym;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.BadRequestException;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.ResourceNotFoundException;
import viniciusDias1001.github.com.SmartFlowGutsGym.repository.GymRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService{

    private final GymRepository gymRepository;

    @Override
    @Transactional
    public GymResponse create(GymDTORequest request) {
        if(gymRepository.existsByNameIgnoreCase(request.name())){
            throw new BadRequestException("This name already exist, try another one!!");
        }

        Gym gym = new Gym();
        gym.setName(request.name().trim());
        gym.setTimezone(request.timezone().trim());
        gym.setCreatedAt(Instant.now());
        Gym saved = gymRepository.save(gym);

        return toResponse(saved);
    }
    @Override
    public GymResponse getById(UUID gymId) {
        Gym gymExist = gymRepository.findById(gymId).orElseThrow(() ->
                new ResourceNotFoundException("Gym Not found   Id:" + gymId));


        return toResponse(gymExist);

    }
    @Override
    public List<GymResponse> listAll() {
        return gymRepository.findAll().stream().map(this::toResponse).toList();
    }
    @Override
    public GymResponse update(UUID gymId, GymDTORequest request) {
        Gym gym = gymRepository.findById(gymId)
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found: " + gymId));
        String newName = request.name().trim();

        if (!gym.getName().equalsIgnoreCase(newName) && gymRepository.existsByNameIgnoreCase(newName)) {
            throw new BadRequestException("This name already exist, try another one");
        }

        gym.setName(newName);
        gym.setTimezone(request.timezone().trim());

        Gym saved = gymRepository.save(gym);
        return toResponse(saved);
    }
    @Override
    @Transactional
    public void delete(UUID gymId) {

        if (!gymRepository.existsById(gymId)) {
            throw new ResourceNotFoundException("Gym Not Fond: " + gymId);
        }
        gymRepository.deleteById(gymId);

    }

    private GymResponse toResponse(Gym gym) {
        return new GymResponse(
                gym.getId(),
                gym.getName(),
                gym.getTimezone(),
                gym.getCreatedAt()
        );
    }
}
