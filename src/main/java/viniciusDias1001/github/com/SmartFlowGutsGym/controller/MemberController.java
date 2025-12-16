package viniciusDias1001.github.com.SmartFlowGutsGym.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberDTORequest;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.dto.MemberResponse;
import viniciusDias1001.github.com.SmartFlowGutsGym.service.MemberServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createNewMember(@RequestBody @Valid MemberDTORequest memberDTORequest){
        return memberService.create(memberDTORequest);

    }
    @GetMapping("/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponse getGymById(@PathVariable UUID memberId){
        return memberService.getById(memberId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MemberResponse> listAll() {
        return memberService.listAll();
    }

    @GetMapping("/by-name")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponse getByName(@RequestParam String name) {
        return memberService.getByName(name);
    }

    @PutMapping("/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponse update(
            @PathVariable UUID memberId,
            @RequestBody @Valid  MemberDTORequest request
    ) {
        return memberService.update(memberId, request);
    }

    @DeleteMapping("/{gymId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID memberId) {
        memberService.delete(memberId);
    }
}
