package Samba.service.maintenances;

import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IMaintenancesService {
    ResponseEntity<GenericResponseDTO> createMaintenance(MaintenancesDTO maintenancesDTO);
    ResponseEntity<GenericResponseDTO> readMaintenance(Integer maintenancesId);
    ResponseEntity<GenericResponseDTO> readAllMaintenance();
    ResponseEntity<GenericResponseDTO> updateMaintenance(MaintenancesDTO maintenancesDTO);
    ResponseEntity<GenericResponseDTO> deleteMaintenance(MaintenancesDTO maintenancesDTO);
}
