package Samba.service.registerActivity;

import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IRegisterActivityService {
    ResponseEntity<GenericResponseDTO> createRegisterActivity(RegisterActivityDTO registerActivityDTO);
    ResponseEntity<GenericResponseDTO> readRegisterActivity(Integer registerActivityId);
    ResponseEntity<GenericResponseDTO> readAllRegisterActivity();
    ResponseEntity<GenericResponseDTO> updateRegisterActivity(RegisterActivityDTO registerActivityDTO);
    ResponseEntity<GenericResponseDTO> deleteRegisterActivity(RegisterActivityDTO registerActivityDTO);
}
