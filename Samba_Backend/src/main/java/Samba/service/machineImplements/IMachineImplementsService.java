package Samba.service.machineImplements;

import Samba.commons.domains.DTO.machine.MachineDTO;
import Samba.commons.domains.DTO.machineImplements.MachineImplementsDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IMachineImplementsService {
    ResponseEntity<GenericResponseDTO> readAllImplement();
}
