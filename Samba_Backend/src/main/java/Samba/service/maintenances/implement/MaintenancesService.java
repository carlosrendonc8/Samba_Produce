package Samba.service.maintenances.implement;

import Samba.commons.constans.response.maintenance.IMaintenanceResponse;
import Samba.commons.converter.maintenance.MaintenanceConverter;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.entity.maintenances.MaintenancesEntity;
import Samba.repository.maintenances.IMaintenancesRepository;
import Samba.service.maintenances.IMaintenancesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class MaintenancesService implements IMaintenancesService {
    @Autowired
    private IMaintenancesRepository iMaintenancesRepository;
    @Autowired
    private MaintenanceConverter maintenanceConverter;


    @Override
    public ResponseEntity<GenericResponseDTO> createMaintenance(MaintenancesDTO maintenancesDTO) {
        try {
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesDTO.maintenancesId);
            if (!maintenanceExist.isPresent()) {
                MaintenancesEntity maintenancesEntity = maintenanceConverter.convertaintenanceDTOToaintenanceEntity(maintenancesDTO);
                this.iMaintenancesRepository.save(maintenancesEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(IMaintenanceResponse.CREATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.OPERATION_FAIL)
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
        }    }

    @Override
    public ResponseEntity<GenericResponseDTO> readMaintenance(Integer maintenancesId) {
        try {
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesId);
            if (!maintenanceExist.isEmpty()) {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(maintenanceExist)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_FAIL)
                        .objectResponse(IMaintenanceResponse.OPERATION_FAIL)
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
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesDTO.maintenancesId);
            if (maintenanceExist.isPresent()) {
                MaintenancesEntity maintenancesEntity = maintenanceConverter.convertaintenanceDTOToaintenanceEntity(maintenancesDTO);
                this.iMaintenancesRepository.save(maintenancesEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMaintenanceResponse.OPERATION_SUCCESS)
                        .objectResponse(IMaintenanceResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            } else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
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
            Optional<MaintenancesEntity> maintenanceExist = this.iMaintenancesRepository.findById(maintenancesDTO.maintenancesId);
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
