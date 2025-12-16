package viniciusDias1001.github.com.SmartFlowGutsGym.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.Gym;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.Member;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.BadRequestException;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.BusinessException;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.exceptions.ResourceNotFoundException;
import viniciusDias1001.github.com.SmartFlowGutsGym.repository.GymRepository;
import viniciusDias1001.github.com.SmartFlowGutsGym.repository.MemberRepository;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements  MemberService{
    private final MemberRepository memberRepository;
    private final GymRepository gymRepository;

    @Override
    public MemberResponse create(MemberDTORequest request) {
        Gym gym = gymRepository.findById(request.gymId())
                .orElseThrow(() -> new EntityNotFoundException("Gym not found"));

        Member member = new Member();
        member.setGym(gym);
        member.setName(request.name());
        member.setExternalCode(generateExternalCode(request.gymId()));
        member.setCreatedAt(Instant.now());
        Member saved = memberRepository.save(member);

        return toResponse(saved);
    }

    @Override
    public MemberResponse getById(UUID memberId) {
       Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new ResourceNotFoundException("Gym Not found   Id:" + memberId));
        return toResponse(member);
    }

    @Override
    public MemberResponse getByName(String nameMember) {
        Member member = memberRepository.findByName(nameMember);
        return toResponse(member);
    }

    @Override
    public List<MemberResponse> listAll() {
        return memberRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public MemberResponse update(UUID memberID, MemberDTORequest request) {
        Member member = memberRepository.findById(memberID)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found: " + memberID));
        String newName = request.name().trim();
        

        member.setName(newName);

        Member saved = memberRepository.save(member);
        return toResponse(saved);
    }

    @Override
    public void delete(UUID memberID) {

        memberRepository.deleteById(memberID);
    }

    private MemberResponse toResponse(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getGym().getId(),
                member.getName(),
                member.getExternalCode(),
                member.getCreatedAt()
        );
    }

    private Integer generateExternalCode(UUID gymId) {
        Random random = new Random();
        Integer code;
        int attempts = 0;

        do {
            code = 100000 + random.nextInt(900000); // 6 dígitos (melhor que 0-9999)
            attempts++;
            if (attempts > 20) {
                throw new BusinessException("Could not generate external code. Try again.");
            }
        } while (memberRepository.existsByGymIdAndExternalCode(gymId, code));

        return code;
    }
}
