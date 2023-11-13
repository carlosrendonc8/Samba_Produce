package Samba.webApi.registerActivity;

import Samba.commons.constans.endpoints.registerActivity.IRegisterActivityEndPoint;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IRegisterActivityApi {
    @PostMapping(IRegisterActivityEndPoint.CREATE_REGISTER_ACTIVITY)
    ResponseEntity<GenericResponseDTO> createRegisterActivity (@RequestBody RegisterActivityDTO registerActivityDTO);
    @GetMapping(IRegisterActivityEndPoint.READ_REGISTER_ACTIVITY)
    ResponseEntity<GenericResponseDTO> readRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO);
    @GetMapping(IRegisterActivityEndPoint.READ_ALL_REGISTER_ACTIVITY)
    ResponseEntity<GenericResponseDTO> readAllRegisterActivity();
    @PutMapping(IRegisterActivityEndPoint.UPDATE_REGISTER_ACTIVITY)
    ResponseEntity<GenericResponseDTO> updateRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO);
    @DeleteMapping(IRegisterActivityEndPoint.DELETE_REGISTER_ACTIVITY)
    ResponseEntity<GenericResponseDTO> deleteRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO);
}
