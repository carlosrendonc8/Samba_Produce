package Samba.webApi.user;

import Samba.commons.constans.endpoints.user.IUserEndPoint;
import Samba.commons.domains.DTO.user.UserDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUserApi {
    @PostMapping(IUserEndPoint.SERVICE_VALIDATION_USER)
    ResponseEntity<GenericResponseDTO> serviceUser(@RequestBody UserDTO userDTO);
    @PostMapping(IUserEndPoint.CREATE_USER)
    ResponseEntity<GenericResponseDTO> saveUser(@RequestBody UserDTO userDTO);
    @PutMapping(IUserEndPoint.UPDATE_USER)
    ResponseEntity<GenericResponseDTO> updateUser(@RequestBody UserDTO userDTO);
    @DeleteMapping(IUserEndPoint.DELETE_USER)
    ResponseEntity<GenericResponseDTO> deleteUser(@RequestBody UserDTO userDTO);
    @DeleteMapping(IUserEndPoint.DELETE_USER)
    ResponseEntity<GenericResponseDTO> deleteUserm2(@PathVariable Integer id);
}