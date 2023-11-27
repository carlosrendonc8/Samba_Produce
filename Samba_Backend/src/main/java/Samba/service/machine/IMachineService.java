package Samba.service.machine;

import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.machine.MachineDTO;
import org.springframework.http.ResponseEntity;

public interface IMachineService
{
    ResponseEntity<GenericResponseDTO> createVehicle(MachineDTO machineDTO);
    ResponseEntity<GenericResponseDTO> readAllVehicle();
    ResponseEntity<GenericResponseDTO> updateVehicle(MachineDTO machineDTO);
    ResponseEntity<GenericResponseDTO> deleteVehicle(Integer machineId);
    ResponseEntity<GenericResponseDTO> readVehicleId(Integer machineId);
}
