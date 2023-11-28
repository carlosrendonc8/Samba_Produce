package Samba.repository.maintenances;

import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaintenancesRepository extends JpaRepository<MaintenancesEntity, Integer> {}
