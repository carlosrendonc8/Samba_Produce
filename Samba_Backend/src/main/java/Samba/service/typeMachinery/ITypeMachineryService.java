package Samba.service.typeMachinery;

import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import org.springframework.http.ResponseEntity;

public interface ITypeMachineryService
{
    ResponseEntity<GenericResponseDTO> createTypeMachinery(TypeMachineryDTO typeMachineryDTO);
    ResponseEntity<GenericResponseDTO> readTypeMachinery(Integer typeMachineryId);
    ResponseEntity<GenericResponseDTO> readAllMachineryForTypeWithMaintenance(Integer typeMachine);
    ResponseEntity<GenericResponseDTO> readAll();
    ResponseEntity<GenericResponseDTO> updateTypeMachinery(TypeMachineryDTO typeMachineryDTO);
    ResponseEntity<GenericResponseDTO> deleteTypeMachinery(Integer typeMachinaryId);
}