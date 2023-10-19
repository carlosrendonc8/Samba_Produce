package Samba.webApi.machineImplements;

import Samba.commons.constans.endpoints.machineImplements.IMachineImplementsEndPoint;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IMachineImplementsApi {
    @GetMapping(IMachineImplementsEndPoint.READ_ALL_IMPLEMENTS)
    ResponseEntity<GenericResponseDTO> readAllImplements();
}
