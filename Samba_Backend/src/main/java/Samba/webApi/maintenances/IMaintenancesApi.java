package Samba.webApi.maintenances;


import Samba.commons.constans.endpoints.maintenance.IMaintenanceEndPoint;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IMaintenancesApi {
    @PostMapping(IMaintenanceEndPoint.CREATE_MAINTENANCE)
    ResponseEntity<GenericResponseDTO> createMaintenance (@RequestBody MaintenancesDTO maintenancesDTO);
    @GetMapping(IMaintenanceEndPoint.READ_MAINTENANCE)
    ResponseEntity<GenericResponseDTO> readMaintenance(@PathVariable Integer maintenancesId);
    @GetMapping(IMaintenanceEndPoint.READ_ALL_MAINTENANCE)
    ResponseEntity<GenericResponseDTO> readAllMaintenance();
    @PutMapping(IMaintenanceEndPoint.UPDATE_MAINTENANCE)
    ResponseEntity<GenericResponseDTO> updateMaintenance(@RequestBody MaintenancesDTO maintenancesDTO);
    @DeleteMapping(IMaintenanceEndPoint.DELETE_MAINTENANCE)
    ResponseEntity<GenericResponseDTO> deleteMaintenance(@RequestBody MaintenancesDTO maintenancesDTO);
}
