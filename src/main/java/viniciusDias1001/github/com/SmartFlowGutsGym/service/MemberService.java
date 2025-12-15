package viniciusDias1001.github.com.SmartFlowGutsGym.service;

import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.GymResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberResponse;

import java.util.List;
import java.util.UUID;

public interface MemberService {

    MemberResponse create(MemberDTORequest request);

    MemberResponse getById(UUID gymId);

    MemberResponse getByName(String nameMember);

    List<MemberResponse> listAll();

    MemberResponse update(UUID memberID, MemberDTORequest request);

    void delete(UUID memberID);
}
