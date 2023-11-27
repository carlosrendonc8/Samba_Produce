package Samba.webApi.machine;

import Samba.commons.constans.endpoints.machine.IMachineEndPoint;
import Samba.commons.domains.DTO.machine.MachineDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Samba.commons.domains.responseDTO.GenericResponseDTO;

public interface IMachineApi
{
        @PostMapping(IMachineEndPoint.CREATE_MACHINE)
        ResponseEntity<GenericResponseDTO> createTypeMachine (@RequestBody MachineDTO machineDTO);
        @GetMapping(IMachineEndPoint.READ_ALL_MACHINE)
        ResponseEntity<GenericResponseDTO> readAllMachine();
        @PutMapping(IMachineEndPoint.UPDATE_MACHINE)
        ResponseEntity<GenericResponseDTO> updateTypeMachine(@RequestBody MachineDTO machineDTO);
        @DeleteMapping(IMachineEndPoint.DELETE_MACHINE)
        ResponseEntity<GenericResponseDTO> deleteTypeMachine(@PathVariable Integer machineId);
        @GetMapping(IMachineEndPoint.READ_MACHINE_ID)
        ResponseEntity<GenericResponseDTO> readMachineId(@PathVariable Integer machineId);
}
