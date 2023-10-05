package Samba.service.typeMachinery;

import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITypeMachineryService
{
    ResponseEntity<GenericResponseDTO> createTypeMachinery(TypeMachineryDTO typeMachineryDTO);
    ResponseEntity<GenericResponseDTO> readTypeMachinery(Integer typeMachineryId);
    ResponseEntity<GenericResponseDTO> readAllMachinery();
    ResponseEntity<GenericResponseDTO> updateTypeMachinery(TypeMachineryDTO typeMachineryDTO);
    ResponseEntity<GenericResponseDTO> deleteTypeMachinery(TypeMachineryDTO typeMachineryDTO);
}