package Samba.webApi.machine.implement;

import Samba.commons.constans.endpoints.machine.IMachineEndPoint;
import Samba.commons.constans.response.machine.IMachineResponse;
import Samba.commons.domains.DTO.machine.MachineDTO;
import Samba.service.machine.implement.MachineService;
import Samba.webApi.machine.IMachineApi;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(IMachineEndPoint.BASE_URL_MACHINE)
@Tag( name = "Sistema de Datos de un CRUD de un Vehiculo" , description = "Opciones de crear, eliminar, actualizar y ver un vehiculo")
public class MachineApi implements IMachineApi
{
    private final MachineService machineService;

    public MachineApi(MachineService machineService) {
        this.machineService = machineService;
    }

    @Override
    @Operation(summary = "crea un vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IMachineEndPoint.CREATE_MACHINE)
    public ResponseEntity<GenericResponseDTO> createTypeMachine(@RequestBody MachineDTO machineDTO) {
        return this.machineService.createVehicle(machineDTO);
    }

    @Override
    @Operation(summary = "lee toda los vehiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMachineEndPoint.READ_ALL_MACHINE)
    public ResponseEntity<GenericResponseDTO> readAllMachine() {
        return this.machineService.readAllVehicle();
    }

    @Override
    @Operation(summary = "actualiza los vehiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.UPDATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping(IMachineEndPoint.UPDATE_MACHINE)
    public ResponseEntity<GenericResponseDTO> updateTypeMachine(@RequestBody MachineDTO machineDTO) {
        return this.machineService.updateVehicle(machineDTO);
    }
    @Override
    @Operation(summary = "elimina un tipo de maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @DeleteMapping(IMachineEndPoint.DELETE_MACHINE)
    public ResponseEntity<GenericResponseDTO> deleteTypeMachine(@PathVariable Integer machineId) {
        return this.machineService.deleteVehicle(machineId);
    }

    @Override
    @Operation(summary = "lee un tipo de maquinaria por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMachineEndPoint.READ_MACHINE_ID)
    public ResponseEntity<GenericResponseDTO> readTypeMachine(@PathVariable Integer machineId) {
        return this.machineService.readVehicleId(machineId);
    }

    @Override
    @Operation(summary = "lee un tipo de maquinaria por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping
    public ResponseEntity<GenericResponseDTO> readMachineId(Integer machineId) {
        return this.machineService.readVehicleId(machineId);
    }
}