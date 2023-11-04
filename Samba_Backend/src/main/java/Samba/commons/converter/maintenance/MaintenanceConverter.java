package Samba.commons.converter.maintenance;

import Samba.commons.constans.response.maintenance.IMaintenanceResponse;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import Samba.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MaintenanceConverter {
    public MaintenancesDTO convertMaintenanceEntityToMaintenanceDTO(MaintenancesEntity machineEntity) {
        MaintenancesDTO maintenancesDTO = new MaintenancesDTO();
        try {
            maintenancesDTO = HelperMapper.modelMapper().map(machineEntity, MaintenancesDTO.class);
        } catch (Exception e) {
            log.error(IMaintenanceResponse.CREATE_FAIL + e);
        }
        return maintenancesDTO;
    }

    public MaintenancesEntity convertaintenanceDTOToaintenanceEntity(MaintenancesDTO maintenancesDTO) {
        MaintenancesEntity maintenancesEntity = new MaintenancesEntity();
        try {
            maintenancesEntity = HelperMapper.modelMapper().map(maintenancesDTO, MaintenancesEntity.class);
        } catch (Exception e) {
            log.error(IMaintenanceResponse.CREATE_FAIL + e);
        }
        return maintenancesEntity;
    }
}
