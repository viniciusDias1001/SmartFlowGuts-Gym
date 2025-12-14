package viniciusDias1001.github.com.SmartFlowGutsGym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
