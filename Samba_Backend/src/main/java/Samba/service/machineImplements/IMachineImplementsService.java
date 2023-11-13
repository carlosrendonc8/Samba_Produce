package Samba.service.machineImplements;

import Samba.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IMachineImplementsService {
    ResponseEntity<GenericResponseDTO> readAllImplement();
}
