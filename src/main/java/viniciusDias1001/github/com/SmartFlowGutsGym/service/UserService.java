package viniciusDias1001.github.com.SmartFlowGutsGym.service;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse create(UserDTORequest request);

    UserResponse getById(UUID userId);

    UserResponse getByEmail(String email);

    List<UserResponse> listAllByGym(UUID gymId);

    UserResponse update(UUID userId, UserDTORequest request);

    void delete(UUID userId);
}
