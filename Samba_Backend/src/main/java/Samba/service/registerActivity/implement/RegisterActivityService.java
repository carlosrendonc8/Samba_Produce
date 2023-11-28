package Samba.service.registerActivity.implement;

import Samba.commons.constans.response.registerActivity.IRegisterActivityResponse;
import Samba.commons.converter.registerActivity.RegisterActivityConverter;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.entity.machineImplements.MachineImplementsEntity;
import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.components.MaintenanceLogic;
import Samba.repository.machine.IMachineRepository;
import Samba.repository.machineImplements.IMachineImplementsRepository;
import Samba.repository.registerActivity.IRegisterActivityRepository;
import Samba.service.registerActivity.IRegisterActivityService;
import lombok.extern.log4j.Log4j2;
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
    private final MaintenanceLogic maintenanceLogic;
    private final IMachineImplementsRepository implementsRepository;

    public RegisterActivityService(IRegisterActivityRepository registerActivityRepository, IMachineRepository machineRepository,
                                   RegisterActivityConverter registerActivityConverter, MaintenanceLogic maintenanceLogic,
                                   IMachineImplementsRepository implementsRepository){
        this.machineRepository = machineRepository;
        this.registerActivityRepository = registerActivityRepository;
        this.registerActivityConverter = registerActivityConverter;
        this.maintenanceLogic = maintenanceLogic;
        this.implementsRepository = implementsRepository;
    }
    @Override
    public ResponseEntity<GenericResponseDTO> createRegisterActivity(RegisterActivityDTO registerActivityDTO) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityDTO.getRegisterActivityId());
            Optional<MachineEntity> machineExist = this.machineRepository.findById(registerActivityDTO.getRegisterActivityMachineId());
            Optional<MachineImplementsEntity> implementsExist = this.implementsRepository.findById(registerActivityDTO.getRegisterActivityImplementMachine());
            if (registerExist.isEmpty() && machineExist.isPresent() && implementsExist.isPresent()) {
                RegisterActivityEntity entity = this.registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                MachineEntity machineEntity = machineExist.get();
                machineEntity.setMachineAccumulatedHours(machineEntity.getMachineAccumulatedHours() + registerActivityDTO.getRegisterActivityHours());
                machineEntity.setMachineEngineOilChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineEngineOilChange(), 250));
                machineEntity.setMachineOilFilterChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineOilFilterChange(), 500));
                machineEntity.setMachineFuelFilterChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineFuelFilterChange(), 250));
                machineEntity.setMachineHydraulicOilChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineHydraulicOilChange(), 1000));
                machineEntity.setMachineDifferentialOilChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineDifferentialOilChange(), 1000));
                machineEntity.setMachineFrontAxleLubrication(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineFrontAxleLubrication(), 250));
                machineEntity.setMachinePlanetaryGearOilChange(this.maintenanceLogic.hoursMaintenanceState(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachinePlanetaryGearOilChange(), 500));
                machineEntity.setMachineRockerLubrication(this.maintenanceLogic.hoursMaintenance50State(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineRockerLubrication()));
                machineEntity.setMachineFlannelLubrication(this.maintenanceLogic.hoursMaintenance50State(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineFlannelLubrication()));
                machineEntity.setMachineCrossheadLubrication(this.maintenanceLogic.hoursMaintenance50State(machineEntity.getMachineAccumulatedHours(), machineEntity.getMachineCrossheadLubrication()));
                entity.setRegisterActivityImplementMachine(implementsExist.get().getMachineImplementName());
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
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
    public ResponseEntity<GenericResponseDTO> readRegisterActivity(Integer registerActivityId) {
        try {
            Optional<RegisterActivityEntity> registerExist = this.registerActivityRepository.findById(registerActivityId);
            if (registerExist.isPresent()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(registerExist)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.NOT_FOUND)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
            Optional<MachineEntity> machineExist = this.machineRepository.findById(registerActivityDTO.getRegisterActivityMachineId());
            Optional<MachineImplementsEntity> implementsExist = this.implementsRepository.findById(registerActivityDTO.getRegisterActivityImplementMachine());
            if (registerExist.isPresent() && machineExist.isPresent() && implementsExist.isPresent()) {
                RegisterActivityEntity registerActivityEntity = registerActivityConverter.convertRegisterActivityDTOToRegisterActivityEntity(registerActivityDTO);
                machineExist.get().setMachineAccumulatedHours(machineExist.get().getMachineAccumulatedHours() + registerActivityDTO.getRegisterActivityHours());
                machineExist.get().setMachineEngineOilChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineEngineOilChange(), 250));
                machineExist.get().setMachineOilFilterChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineOilFilterChange(), 500));
                machineExist.get().setMachineFuelFilterChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineFuelFilterChange(), 250));
                machineExist.get().setMachineHydraulicOilChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineHydraulicOilChange(), 1000));
                machineExist.get().setMachineDifferentialOilChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineDifferentialOilChange(), 1000));
                machineExist.get().setMachineFrontAxleLubrication(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineFrontAxleLubrication(), 250));
                machineExist.get().setMachinePlanetaryGearOilChange(this.maintenanceLogic.hoursMaintenanceState(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachinePlanetaryGearOilChange(), 500));
                machineExist.get().setMachineRockerLubrication(this.maintenanceLogic.hoursMaintenance50State(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineRockerLubrication()));
                machineExist.get().setMachineFlannelLubrication(this.maintenanceLogic.hoursMaintenance50State(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineFlannelLubrication()));
                machineExist.get().setMachineCrossheadLubrication(this.maintenanceLogic.hoursMaintenance50State(machineExist.get().getMachineAccumulatedHours(), machineExist.get().getMachineCrossheadLubrication()));
                registerActivityEntity.setRegisterActivityImplementMachine(implementsExist.get().getMachineImplementName());
                this.registerActivityRepository.save(registerActivityEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.UPDATE_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
                Optional<MachineEntity> machineExist = this.machineRepository.findById(registerActivityDTO.getRegisterActivityMachineId());
                machineExist.get().setMachineAccumulatedHours(machineExist.get().getMachineAccumulatedHours() - registerActivityDTO.getRegisterActivityHours());
                this.registerActivityRepository.delete(registerExist.get());
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_SUCCESS)
                        .objectResponse(IRegisterActivityResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IRegisterActivityResponse.OPERATION_FAIL)
                        .objectResponse(IRegisterActivityResponse.DELETE_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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