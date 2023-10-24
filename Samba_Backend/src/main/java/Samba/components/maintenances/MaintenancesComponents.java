package Samba.components.maintenances;

import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.entity.accumulatedHours.AccumulatedHoursEntity;
import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import Samba.repository.accumulatedHours.IAccumulatedHoursRepository;
import Samba.repository.maintenances.IMaintenancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MaintenancesComponents {
    @Autowired
    private IMaintenancesRepository iMaintenancesRepository;
    @Autowired
    private IAccumulatedHoursRepository iAccumulatedHoursRepository;
    public String Example(RegisterActivityDTO registerActivityDTO) {
        List<MaintenancesEntity> listMaintenance = this.iMaintenancesRepository.findAll();
        Optional<AccumulatedHoursEntity> accumulatedHoursEntity= iAccumulatedHoursRepository.findById(registerActivityDTO.getMachineEntity().getMachineSambaId());

        for(MaintenancesEntity maintenancesEntity: listMaintenance) {
            System.out.println("prueba estados" + maintenancesEntity.getMaintenancesName());

        }

        return null;
    }
}