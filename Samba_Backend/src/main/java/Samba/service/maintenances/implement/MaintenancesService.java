package Samba.service.maintenances.implement;

import Samba.commons.constans.response.maintenance.IMaintenanceResponse;
import Samba.commons.converter.maintenance.MaintenanceConverter;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import Samba.components.MaintenanceLogic;
import Samba.repository.machine.IMachineRepository;
import Samba.repository.maintenances.IMaintenancesRepository;
import Samba.repository.typeMachinery.ITypeMachineryRepository;
import Samba.service.maintenances.IMaintenancesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class MaintenancesService implements IMaintenancesService {
    private final IMaintenancesRepository iMaintenancesRepository;
    private final MaintenanceConverter maintenanceConverter;
    private final IMachineRepository machineRepository;
    private final MaintenanceLogic maintenanceLogic;
    private final ITypeMachineryRepository typeMachineryRepository;

    public MaintenancesService(IMaintenancesRepository iMaintenancesRepository, MaintenanceConverter maintenanceConverter,
                               IMachineRepository machineRepository, MaintenanceLogic maintenanceLogic, ITypeMachineryRepository typeMachineryRepository){
        this.iMaintenancesRepository = iMaintenancesRepository;
        this.machineRepository = machineRepository;
        this.maintenanceConverter = maintenanceConverter;
        this.maintenanceLogic = maintenanceLogic;
        this.typeMachineryRepository = typeMachineryRepository;
    }


    @Override
    public ResponseEntity<GenericResponseDTO> createMaintenance(MaintenancesDTO maintenancesDTO) {
        try{
            Optional<MaintenancesEntity> maintenancesEntityExist = this.iMaintenancesRepository.findById(maintenancesDTO.getMaintenancesId());
            Optional<MachineEntity> machineEntityExist = this.machineRepository.findById(maintenancesDTO.getMachineId());
            if(maintenancesEntityExist.isEmpty()){
                if(machineEntityExist.isPresent()){
                    MachineEntity machineEntity = machineEntityExist.get();
                    MaintenancesEntity entity = this.maintenanceConverter.convertaintenanceDTOToaintenanceEntity(maintenancesDTO);
                    if(maintenancesDTO.getMaintenancesType().equalsIgnoreCase("cambio de aceite de motor")){
                        machineEntity.setMachineEngineOilChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachineEngineOilChange()));
                    }
                    if(maintenancesDTO.getMaintenancesType().equalsIgnoreCase("cambio de filtro de aceite")){
                        machineEntity.setMachineOilFilterChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachineOilFilterChange()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("cambio del filtro de combustible")){
                        machineEntity.setMachineFuelFilterChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachineFuelFilterChange()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Cambio de aceite hidráulico ")){
                        machineEntity.setMachineHydraulicOilChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachineHydraulicOilChange()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Cambio de aceite del diferencial")){
                        machineEntity.setMachineDifferentialOilChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachineDifferentialOilChange()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Lubricación eje delantero")){
                        machineEntity.setMachineFrontAxleLubrication(this.maintenanceLogic.addMaintenance(machineEntity.getMachineFrontAxleLubrication()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Cambio de aceite engranaje planetario")){
                        machineEntity.setMachinePlanetaryGearOilChange(this.maintenanceLogic.addMaintenance(machineEntity.getMachinePlanetaryGearOilChange()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Lubricacion del balancin")){
                        machineEntity.setMachineRockerLubrication(this.maintenanceLogic.addMaintenance(machineEntity.getMachineRockerLubrication()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Lubricacion de chanelas")){
                        machineEntity.setMachineFlannelLubrication(this.maintenanceLogic.addMaintenance(machineEntity.getMachineFlannelLubrication()));
                    }
                    if (maintenancesDTO.getMaintenancesType().equalsIgnoreCase("Lubricacion de crucetas")){
                        machineEntity.setMachineCrossheadLubrication(this.maintenanceLogic.addMaintenance(machineEntity.getMachineCrossheadLubrication()));
                    }
                    entity.setMaintenanceMachineName(machineEntity.getMachineName());
                    this.iMaintenancesRepository.save(entity);
                    return ResponseEntity.ok(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.OPERATION_SUCCESS)
                            .objectResponse(IMaintenanceResponse.CREATE_SUCCESS)
                            .statusCode(HttpStatus.OK.value())
                            .build());
                } else {
                    return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.OPERATION_FAIL + " La maquina pasada como id no existe")
                            .objectResponse(IMaintenanceResponse.CREATE_FAIL)
                            .statusCode(HttpStatus.OK.value())
                            .build());
                }
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL + " Ya hay un mantenimiento registrado con este id")
                        .objectResponse(IMaintenanceResponse.CREATE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e){
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readMaintenance(Integer maintenancesId) {
        try {
            Optional<MaintenancesEntity> maintenancesEntityExist = this.iMaintenancesRepository.findById(maintenancesId);
            if(maintenancesEntityExist.isPresent()){
                MaintenancesEntity entity = maintenancesEntityExist.get();
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(entity)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL + " No hay mantenimiento registrado con este id")
                        .objectResponse(IMaintenanceResponse.CREATE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e){
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }


    @Override
    public ResponseEntity<GenericResponseDTO> readAllMaintenance() {
        try {
            List<MaintenancesEntity> listDTO = this.iMaintenancesRepository.findAll();
            List<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findAll();
            if (!maintenanceExist.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(listDTO)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.OPERATION_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        }
        catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateMaintenance(MaintenancesDTO maintenancesDTO) {
        try {
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesDTO.getMaintenancesId());
            if (maintenanceExist.isPresent()) {
                MaintenancesEntity maintenancesEntity = maintenanceConverter.convertaintenanceDTOToaintenanceEntity(maintenancesDTO);
                this.iMaintenancesRepository.save(maintenancesEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(IMaintenanceResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.UPDATE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteMaintenance(MaintenancesDTO maintenancesDTO) {
        try {
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesDTO.getMaintenancesId());
            if (maintenanceExist.isPresent()) {
                MaintenancesEntity maintenancesEntity = maintenanceConverter.convertaintenanceDTOToaintenanceEntity(maintenancesDTO);
                this.iMaintenancesRepository.delete(maintenancesEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(IMaintenanceResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.DELETE_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> thereAreMaintenancesForTypeMachine(Integer typeMachineId) {
        try {
            Optional<TypeMachineryEntity> typeMachineExist = this.typeMachineryRepository.findById(typeMachineId);
            List<TypeMachineryEntity> typeMachineryEntityList = this.typeMachineryRepository.findAll();
            if (typeMachineExist.isPresent()) {
                List<MachineEntity> machineEntityList = this.machineRepository.findAll();
                if (machineEntityList.isEmpty()) {
                    return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.OPERATION_FAIL)
                            .objectResponse(IMaintenanceResponse.OPERATION_FAIL + ", no existen maquinas por lo tanto no hay mantenimientos")
                            .statusCode(HttpStatus.OK.value())
                            .build());
                } else {
                    String response = "NO hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                    for (MachineEntity machine : machineEntityList) {
                        if(machine.getMachineType().equals(typeMachineExist.get().getTypeMachinaryName())){
                            if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineEngineOilChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineOilFilterChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineFuelFilterChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineHydraulicOilChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineDifferentialOilChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineFrontAxleLubrication())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachinePlanetaryGearOilChange())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineRockerLubrication())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineFlannelLubrication())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            } else if(this.maintenanceLogic.doesItHaveMaintenance(machine.getMachineCrossheadLubrication())){
                                response = "SI hay mantenimientos pendientes para el tipo de maquina " + typeMachineExist.get().getTypeMachinaryName();
                            }
                        }
                    }
                    return ResponseEntity.ok(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.OPERATION_SUCCESS)
                            .objectResponse(response)
                            .statusCode(HttpStatus.OK.value())
                            .build());
                }
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.OPERATION_FAIL + ", El tipo de maquina pasado como id no existe")
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IMaintenanceResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
