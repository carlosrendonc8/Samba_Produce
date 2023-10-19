package Samba.service.machineImplements.implement;

import Samba.commons.constans.response.machine.IMachineResponse;
import Samba.commons.converter.machineImplements.MachineImplementsConverter;
import Samba.commons.domains.DTO.machineImplements.MachineImplementsDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.machineImplements.MachineImplementsEntity;
import Samba.repository.machineImplements.IMachineImplementsRepository;
import Samba.service.machineImplements.IMachineImplementsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Log4j2
@Service
public class MachineImplementsService implements IMachineImplementsService {
    @Autowired
    public IMachineImplementsRepository iMachineImplementsRepository;
    @Autowired
    public MachineImplementsConverter machineImplementsConverter;


    @Override
    public ResponseEntity<GenericResponseDTO> readAllImplement() {
        try {
            List<MachineImplementsDTO> listDTO = new ArrayList<>();
            List<MachineImplementsEntity> implementExist = this.iMachineImplementsRepository.findAll();
            if (!implementExist.isEmpty()) {
                System.out.println("Entramos al Metodo leer");
                implementExist.forEach(item -> listDTO.add(machineImplementsConverter.convertMachineImplementsEntityToMachineImplementsDTO(item)));
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMachineResponse.OPERATION_SUCCESS)
                        .objectResponse(listDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMachineResponse.OPERATION_FAIL)
                        .objectResponse(IMachineResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        }
        catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMachineResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
