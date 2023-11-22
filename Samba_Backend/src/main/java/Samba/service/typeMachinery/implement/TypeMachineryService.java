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
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_FAIL)
                        .objectResponse(ITypeMachineryResponse.NOT_FOUND)
                        .statusCode(HttpStatus.OK.value())
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
    public ResponseEntity<GenericResponseDTO> readAllMachineryForTypeWithMaintenance(Integer typeMachinaryId) {
        System.out.println(typeMachinaryId);
        try {
            Optional<TypeMachineryEntity> typeMachineryEntityExist = this.typeMachineryRepository.findById(typeMachinaryId);
            List<MachineEntity> machineEntityExist = this.machineRepository.findAll();
            System.out.println(typeMachineryEntityExist);
            System.out.println(machineEntityExist);
            if (typeMachineryEntityExist.isPresent() && !machineEntityExist.isEmpty()) {
                List<MachineEntity> machineWithMaintenanceList = new ArrayList<>();
                for(MachineEntity machineEntity : machineEntityExist){
                    if(machineEntity.getMachineType().equals(typeMachineryEntityExist.get().getTypeMachinaryName())){
                        if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineEngineOilChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineOilFilterChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineFuelFilterChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineHydraulicOilChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineDifferentialOilChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineFrontAxleLubrication())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachinePlanetaryGearOilChange())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineRockerLubrication())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineFlannelLubrication())){
                            machineWithMaintenanceList.add(machineEntity);
                        } else if(this.maintenanceLogic.doesItHaveMaintenance(machineEntity.getMachineCrossheadLubrication())){
                            machineWithMaintenanceList.add(machineEntity);
                        }
                    }
                }
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(ITypeMachineryResponse.OPERATION_SUCCESS)
                        .objectResponse(machineWithMaintenanceList)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
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
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachineryDTO.getTypeMachinaryId());
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
    public ResponseEntity<GenericResponseDTO> deleteTypeMachinery(Integer typeMachinaryId) {
        try {
            Optional<TypeMachineryEntity> typeMachineryExist = this.typeMachineryRepository.findById(typeMachinaryId);
            List<MachineEntity> machineEntityList = this.machineRepository.findAll();
            if (typeMachineryExist.isPresent()) {
                TypeMachineryEntity typeMachineryEntity = typeMachineryExist.get();
                if(!machineEntityList.isEmpty()){
                    for(MachineEntity machineEntity : machineEntityList){
                        if(machineEntity.getMachineType().equals(typeMachineryEntity.getTypeMachinaryName())){
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