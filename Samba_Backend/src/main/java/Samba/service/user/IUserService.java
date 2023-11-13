package Samba.service.user;

import Samba.commons.domains.DTO.user.UserDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<GenericResponseDTO> serviceUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> saveUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> updateUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> deleteUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> deleteUserm2(Integer id);
}