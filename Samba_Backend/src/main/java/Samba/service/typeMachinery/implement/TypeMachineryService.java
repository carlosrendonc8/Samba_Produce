package Samba.service.typeMachinery.implement;

import Samba.commons.constans.response.typeMachinery.ITypeMachineryResponse;
import Samba.commons.converter.typeMachinery.TypeMachineryConverter;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;
import Samba.components.MaintenanceLogic;
import Samba.repository.machine.IMachineRepository;
import Samba.repository.typeMachinery.ITypeMachineryRepository;
import Samba.service.typeMachinery.ITypeMachineryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Log4j2
@Service
public class TypeMachineryService implements ITypeMachineryService
{
    private final ITypeMachineryRepository typeMachineryRepository;
    private final TypeMachineryConverter typeMachineryConverter;
    private final IMachineRepository machineRepository;
    private final MaintenanceLogic maintenanceLogic;
    public TypeMachineryService(ITypeMachineryRepository typeMachineryRepository, TypeMachineryConverter typeMachineryConverter,
                                IMachineRepository machineRepository, MaintenanceLogic maintenanceLogic){
        this.typeMachineryConverter = typeMachineryConverter;
        this.typeMachineryRepository = typeMachineryRepository;
        this.machineRepository = machineRepository;
        this.maintenanceLogic = maintenanceLogic;
    }
    @Override
    public ResponseEntity<GenericResponseDTO> createTypeMachinery(TypeMachineryDTO typeMachineryDTO) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryDTO.getTypeMachinaryId());
            if (!typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryConverter.convertTypeMachineryDTOToTypeMachineryEntity(typeMachineryDTO);
                this.typeMachineryRepository.save(typeMachineryEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(ITypeMachineryResponse.CREATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
                TypeMachineryEntity entity = typeMachineryExist.get();
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(entity)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
    public ResponseEntity<GenericResponseDTO> readAll(){
        try {
            List<TypeMachineryEntity> list = this.typeMachineryRepository.findAll();
            if(!list.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(list)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.NOT_FOUND)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e){
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
    public ResponseEntity<GenericResponseDTO> bringAllMachinesEnablesForTypeMachine(Integer typeMachineryId){
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryId);
            List<MachineEntity> machineList = this.machineRepository.findAll();
            List<MachineEntity> machinesEnable = new ArrayList<>();
            if(typeMachineryExist.isPresent() && !machineList.isEmpty()){
                for(MachineEntity machineEntity : machineList) {
                    if (machineEntity.getMachineType().equals(typeMachineryExist.get().getTypeMachineryName())) {
                        if (!this.maintenanceLogic.needMaintenance(machineEntity.getMachineEngineOilChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineOilFilterChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineFuelFilterChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineHydraulicOilChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineDifferentialOilChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineFrontAxleLubrication()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachinePlanetaryGearOilChange()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineRockerLubrication()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineFlannelLubrication()) &&
                            !this.maintenanceLogic.needMaintenance(machineEntity.getMachineCrossheadLubrication())) {
                                machinesEnable.add(machineEntity);
                        }
                    }
                }
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(machinesEnable)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
    public ResponseEntity<GenericResponseDTO> getTypeMachineryState(Integer typeMachineryId){
        try {
            String state = "";
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryId);
            if(typeMachineryExist.isPresent()){
                List<MachineEntity> machines = this.machineRepository.findAll();
                for(MachineEntity machineEntity : machines){
                    if(machineEntity.getMachineType().equals(typeMachineryExist.get().getTypeMachineryName())){
                        if(machineEntity.getMachineState().equals("HABILITADA")){
                            state = machineEntity.getMachineState();
                        } else if (machineEntity.getMachineState().equals("PRECAUCION")) {
                            state = machineEntity.getMachineState();
                        } else if (machineEntity.getMachineState().equals("ALERTA")){
                            state = machineEntity.getMachineState();
                        }
                    }
                }
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(state)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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
    public ResponseEntity<GenericResponseDTO> deleteTypeMachinery(Integer typeMachineryId) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryId);
            List<MachineEntity> machineEntityList = this.machineRepository.findAll();
            if (typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryExist.get();
                if(!machineEntityList.isEmpty()){
                    for(MachineEntity machineEntity : machineEntityList){
                        if(machineEntity.getMachineType().equals(typeMachineryEntity.getTypeMachineryName())){
                            this.machineRepository.delete(machineEntity);
                        }
                    }
                }
                this.typeMachineryRepository.delete(typeMachineryEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(ITypeMachineryResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.DELETE_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
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