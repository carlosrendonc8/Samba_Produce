package Samba.service.typeMachinery.implement;

import Samba.commons.constans.response.typeMachinery.ITypeMachineryResponse;
import Samba.commons.converter.typeMachinery.TypeMachineryConverter;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;
import Samba.repository.typeMachinery.ITypeMachineryRepository;
import Samba.service.typeMachinery.ITypeMachineryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Log4j2
@Service
public class TypeMachineryService implements ITypeMachineryService
{
    @Autowired
    public ITypeMachineryRepository typeMachineryRepository;
    @Autowired
    public TypeMachineryConverter typeMachineryConverter;
    @Override
    public ResponseEntity<GenericResponseDTO> createTypeMachinery(TypeMachineryDTO typeMachineryDTO) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryDTO.typeMachinaryId);
            if (!typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryConverter.convertTypeMachineryDTOToTypeMachineryEntity(typeMachineryDTO);
                this.typeMachineryRepository.save(typeMachineryEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(ITypeMachineryResponse.CREATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(ITypeMachineryResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
    @Override
    public ResponseEntity<GenericResponseDTO> readTypeMachinery(Integer typeMachineryId) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryId);
            if (typeMachineryExist.isPresent()) {
                TypeMachineryDTO typeMachineryDTO =
                        this.typeMachineryConverter.convertTypeMachineryEntityToTypeMachineryDTO(typeMachineryExist.get());
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(typeMachineryDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(ITypeMachineryResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
    @Override
    public ResponseEntity<GenericResponseDTO> readAllMachinery() {
        try {
            List<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findAll();
            if (!typeMachineryExist.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(typeMachineryExist)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(ITypeMachineryResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
    @Override
    public ResponseEntity<GenericResponseDTO> updateTypeMachinery(TypeMachineryDTO typeMachineryDTO) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryDTO.typeMachinaryId);
            if (typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryConverter.convertTypeMachineryDTOToTypeMachineryEntity(typeMachineryDTO);
                this.typeMachineryRepository.save(typeMachineryEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(ITypeMachineryResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.UPDATE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(ITypeMachineryResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteTypeMachinery(TypeMachineryDTO typeMachineryDTO) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryDTO.typeMachinaryId);
            if (typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryConverter.convertTypeMachineryDTOToTypeMachineryEntity(typeMachineryDTO);
                this.typeMachineryRepository.delete(typeMachineryEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(ITypeMachineryResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.DELETE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(ITypeMachineryResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}