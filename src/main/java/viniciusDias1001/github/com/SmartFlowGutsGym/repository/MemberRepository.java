package viniciusDias1001.github.com.SmartFlowGutsGym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.Member;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
}
