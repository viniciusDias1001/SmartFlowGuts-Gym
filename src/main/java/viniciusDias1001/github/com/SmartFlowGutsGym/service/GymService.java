package viniciusDias1001.github.com.SmartFlowGutsGym.service;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymResponse;
import java.util.List;
import java.util.UUID;


public interface GymService {

    GymResponse create(GymDTORequest request);

    GymResponse getById(UUID gymId);

    List<GymResponse> listAll();

    GymResponse update(UUID gymId, GymDTORequest request);

    void delete(UUID gymId);
}
