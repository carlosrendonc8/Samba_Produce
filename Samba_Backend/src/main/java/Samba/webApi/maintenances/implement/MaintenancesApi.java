package Samba.webApi.maintenances.implement;

import Samba.commons.constans.endpoints.maintenance.IMaintenanceEndPoint;
import Samba.commons.constans.response.maintenance.IMaintenanceResponse;
import Samba.commons.domains.DTO.maintenances.MaintenancesDTO;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import Samba.service.maintenances.implement.MaintenancesService;
import Samba.webApi.maintenances.IMaintenancesApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IMaintenanceEndPoint.BASE_URL_MAINTENANCE)
@Tag( name = "Sistema de Datos de un CRUD de Mantenimientos" , description = "Opciones de crear, eliminar, actualizar y ver mantenimientos")
@Log4j2
public class MaintenancesApi implements IMaintenancesApi {
    private final MaintenancesService maintenancesService;

    public MaintenancesApi(MaintenancesService maintenancesService) {this.maintenancesService = maintenancesService;}

    @Override
    @Operation(summary = "crea un mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMaintenanceResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMaintenanceResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IMaintenanceEndPoint.CREATE_MAINTENANCE)
    public ResponseEntity<GenericResponseDTO> createMaintenance(MaintenancesDTO maintenancesDTO) {
        return this.maintenancesService.createMaintenance(maintenancesDTO);
    }

    @Override
    @Operation(summary = "Lee un Mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMaintenanceResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMaintenanceResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMaintenanceEndPoint.READ_MAINTENANCE)
    public ResponseEntity<GenericResponseDTO> readMaintenance(Integer maintenancesId) {
        return this.maintenancesService.readMaintenance(maintenancesId);
    }

    @Override
    @Operation(summary = "lee todos los mantenimientos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMaintenanceResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMaintenanceResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMaintenanceEndPoint.READ_ALL_MAINTENANCE)
    public ResponseEntity<GenericResponseDTO> readAllMaintenance() {
        return this.maintenancesService.readAllMaintenance();
    }

    @Override
    @Operation(summary = "Actualiza un mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMaintenanceResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMaintenanceResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMaintenanceEndPoint.UPDATE_MAINTENANCE)
    public ResponseEntity<GenericResponseDTO> updateMaintenance(MaintenancesDTO maintenancesDTO) {
        return this.maintenancesService.updateMaintenance(maintenancesDTO);
    }

    @Override
    @Operation(summary = "Elimina un mantenimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMaintenanceResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMaintenanceResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMaintenanceResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMaintenanceEndPoint.DELETE_MAINTENANCE)
    public ResponseEntity<GenericResponseDTO> deleteMaintenance(MaintenancesDTO maintenancesDTO) {
        return this.maintenancesService.deleteMaintenance(maintenancesDTO);
    }
}