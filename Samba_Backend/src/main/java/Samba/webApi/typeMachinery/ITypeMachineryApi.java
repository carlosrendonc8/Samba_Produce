package Samba.webApi.typeMachinery;
import Samba.commons.constans.endpoints.typeMachinery.ITypeMachineEndPoint;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
public interface ITypeMachineryApi
{
    @PostMapping(ITypeMachineEndPoint.CREATE_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> createTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO);
    @GetMapping(ITypeMachineEndPoint.READ_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> readTypeMachinery(@PathVariable Integer typeMachineryId);
    @GetMapping(ITypeMachineEndPoint.READ_ALL_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> readAllMachineryForTypeWithMaintenance(Integer typeMachineId);
    @PutMapping(ITypeMachineEndPoint.UPDATE_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> updateTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO);
    @DeleteMapping(ITypeMachineEndPoint.DELETE_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> deleteTypeMachinery(@PathVariable Integer typeMachinaryId);
}
