package viniciusDias1001.github.com.SmartFlowGutsGym.repository;

import viniciusDias1001.github.com.SmartFlowGutsGym.domain.entities.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface CheckInRepository extends JpaRepository<CheckIn, UUID> {


    @Query("""
        select c
        from CheckIn c
        where c.gym.id = :gymId
          and c.occurredAt between :start and :end
        order by c.occurredAt
    """)
    List<CheckIn> findByGymAndPeriod(
            @Param("gymId") UUID gymId,
            @Param("start") Instant start,
            @Param("end") Instant end
    );

    /**
     * Verifica se um membro já fez check-in em um período.
     * Usado para evitar duplicidade de entrada.
     */
    boolean existsByMemberIdAndOccurredAtBetween(
            UUID memberId,
            Instant start,
            Instant end
    );

    /**
     * Conta check-ins por academia em um intervalo.
     * Base para dashboards.
     */
    long countByGymIdAndOccurredAtBetween(
            UUID gymId,
            Instant start,
            Instant end
    );

    /**
     * Retorna histórico de check-ins de um membro.
     */
    List<CheckIn> findByMemberIdOrderByOccurredAtDesc(UUID memberId);
}
