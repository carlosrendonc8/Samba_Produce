package Samba.service.registerActivity.implement;

import Samba.commons.constans.response.registerActivity.IRegisterActivityResponse;
import Samba.commons.converter.registerActivity.RegisterActivityConverter;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.accumulatedHours.AccumulatedHoursEntity;
import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import Samba.components.maintenances.MaintenancesComponents;
import Samba.repository.accumulatedHours.IAccumulatedHoursRepository;
import Samba.repository.registerActivity.IRegisterActivityRepository;
import Samba.service.registerActivity.IRegisterActivityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Log4j2
public class RegisterActivityService implements IRegisterActivityService {
    @Autowired
    private IRegisterActivityRepository registerActivityRepository;
    @Autowired
    private IAccumulatedHoursRepository accumulatedHoursRepository;
    @Autowired
    private MaintenancesComponents maintenancesComponents;
    @Autowired
    private RegisterActivityConverter registerActivityConverter;
    @Override
    public ResponseEntity<GenericResponseDTO> createRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.registerActivityId);
            if (!registerExist.isPresent()) {
                RegisterActivityEntity registerActivityEntity = registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                this.registerActivityRepository.save(registerActivityEntity);
                AccumulatedHoursEntity accumulatedHoursEntity = new AccumulatedHoursEntity();
                accumulatedHoursEntity.setAccumulatedHoursId(0);
                accumulatedHoursEntity.setMachineEntity(registerActivityEntity.getMachineEntity());
                accumulatedHoursEntity.setAccumulatedHoursHours(registerActivityEntity.getRegisterActivityHours());
                this.accumulatedHoursRepository.save(accumulatedHoursEntity);
                //maintenancesComponents.Example(registerActivityDTO);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.CREATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IRegisterActivityResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.registerActivityId);
            if (registerExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(registerExist)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IRegisterActivityResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readAllRegisterActivity() {
        try {
            List<RegisterActivityEntity> registerExist = this.registerActivityRepository.findAll();
            if (!registerExist.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(registerExist)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        }
        catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IRegisterActivityResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.registerActivityId);
            if (registerExist.isPresent()) {
                RegisterActivityEntity registerActivityEntity = registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                this.registerActivityRepository.save(registerActivityEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.UPDATE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IRegisterActivityResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.registerActivityId);
            if (registerExist.isPresent()) {
                RegisterActivityEntity registerActivityEntity = registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                this.registerActivityRepository.delete(registerActivityEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.DELETE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IRegisterActivityResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}