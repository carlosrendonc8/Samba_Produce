package Samba.service.registerActivity.implement;

import Samba.commons.constans.response.registerActivity.IRegisterActivityResponse;
import Samba.commons.converter.registerActivity.RegisterActivityConverter;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import Samba.repository.machine.IMachineRepository;
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

    private final IRegisterActivityRepository registerActivityRepository;
    private final IMachineRepository machineRepository;
    private final RegisterActivityConverter registerActivityConverter;

    @Autowired
    public RegisterActivityService(IRegisterActivityRepository registerActivityRepository, IMachineRepository machineRepository, RegisterActivityConverter registerActivityConverter){
        this.machineRepository = machineRepository;
        this.registerActivityRepository = registerActivityRepository;
        this.registerActivityConverter = registerActivityConverter;
    }
    @Override
    public ResponseEntity<GenericResponseDTO> createRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.getRegisterActivityId());
            Optional<MachineEntity> machineExist = this.machineRepository.findById(registerActivityDTO.getRegisterActivityMachineId());
            if (!registerExist.isPresent() && machineExist.isPresent()) {
                RegisterActivityEntity entity = this.registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                MachineEntity machineEntity = machineExist.get();
                machineEntity.setMachineAccumulatedHours(machineEntity.getMachineAccumulatedHours() + registerActivityDTO.getRegisterActivityHours());
                this.registerActivityRepository.save(entity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.CREATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
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
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.getRegisterActivityId());
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
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.getRegisterActivityId());
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
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.getRegisterActivityId());
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