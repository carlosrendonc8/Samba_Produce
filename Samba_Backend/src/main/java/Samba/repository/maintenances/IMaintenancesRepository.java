package Samba.repository.maintenances;

import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaintenancesRepository extends JpaRepository<MaintenancesEntity, Integer> {
}
