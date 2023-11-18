package Samba.service.maintenances.implement;

import Samba.commons.constans.response.maintenance.IMaintenanceResponse;
import Samba.commons.converter.maintenance.MaintenanceConverter;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import Samba.components.MaintenanceLogic;
import Samba.repository.machine.IMachineRepository;
import Samba.repository.maintenances.IMaintenancesRepository;
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

    public MaintenancesService(IMaintenancesRepository iMaintenancesRepository, MaintenanceConverter maintenanceConverter, IMachineRepository machineRepository, MaintenanceLogic maintenanceLogic){
        this.iMaintenancesRepository = iMaintenancesRepository;
        this.machineRepository = machineRepository;
        this.maintenanceConverter = maintenanceConverter;
        this.maintenanceLogic = maintenanceLogic;
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
                    System.out.println("DTO id: " + maintenancesDTO.getMaintenancesId());
                    System.out.println("entity id: " + entity.getMaintenancesId());
                    System.out.println("DTO typo de mantenimiento: " + maintenancesDTO.getMaintenancesType());
                    System.out.println("entity tipo de mantenimiento: " + entity.getMaintenancesType());
                    System.out.println("DTO date: " + maintenancesDTO.getMaintenanceDate());
                    System.out.println("entity date: " + entity.getMaintenanceDate());
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
        return null;
    }


    @Override
    public ResponseEntity<GenericResponseDTO> readAllMaintenance() {
        try {
            List<MaintenancesDTO> listDTO = new ArrayList<>();
            List<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findAll();
            if (!maintenanceExist.isEmpty()) {
                System.out.println("Entramos al Metodo leer");
                maintenanceExist.forEach(item -> listDTO.add(maintenanceConverter.convertMaintenanceEntityToMaintenanceDTO(item)));
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
                return ResponseEntity.ok(GenericResponseDTO.builder()
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
}
