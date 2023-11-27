package Samba.webApi.typeMachinery;
import Samba.commons.constans.endpoints.typeMachinery.ITypeMachineryEndPoint;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
public interface ITypeMachineryApi
{
    @PostMapping(ITypeMachineryEndPoint.CREATE_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> createTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO);
    @GetMapping(ITypeMachineryEndPoint.READ_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> readTypeMachinery(@PathVariable Integer typeMachineryId);
    @GetMapping(ITypeMachineryEndPoint.READ_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> bringAllMachinesEnablesForTypeMachine(@PathVariable Integer typeMachineryId);
    @GetMapping
    ResponseEntity<GenericResponseDTO> readAll();
    @DeleteMapping(ITypeMachineryEndPoint.DELETE_TYPE_MACHINERY)
    ResponseEntity<GenericResponseDTO> deleteTypeMachinery(@PathVariable Integer typeMachineryId);
}
