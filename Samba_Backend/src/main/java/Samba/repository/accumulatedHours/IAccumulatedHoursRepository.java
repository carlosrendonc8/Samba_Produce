package Samba.repository.accumulatedHours;

import Samba.commons.domains.entity.accumulatedHours.AccumulatedHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccumulatedHoursRepository extends JpaRepository<AccumulatedHoursEntity, Integer> {
}