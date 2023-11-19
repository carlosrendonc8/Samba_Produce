
package Samba.webApi.typeMachinery.implement;

import Samba.commons.constans.endpoints.typeMachinery.ITypeMachineEndPoint;
import Samba.commons.constans.response.typeMachinery.ITypeMachineryResponse;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import Samba.service.typeMachinery.implement.TypeMachineryService;
import Samba.webApi.typeMachinery.ITypeMachineryApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(ITypeMachineEndPoint.BASE_URL_TYPE_MACHINERY)
@Tag( name = "Sistema de Datos de un CRUD de tipo de maquinaria" , description = "Opciones de crear, eliminar, actualizar y ver un tipo de maquinaria")
@Log4j2
public class TypeMachineryApi implements ITypeMachineryApi
{
    private final TypeMachineryService typeMachineryService;
    public TypeMachineryApi(TypeMachineryService typeMachineryService) {
        this.typeMachineryService = typeMachineryService;
    }
    @Override
    @Operation(summary = "crea un tipo de maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ITypeMachineryResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ITypeMachineryResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(ITypeMachineEndPoint.CREATE_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> createTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO) {
        return this.typeMachineryService.createTypeMachinery(typeMachineryDTO);
    }
    @Override
    @Operation(summary = "lee un tipo de maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ITypeMachineryResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ITypeMachineryResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(ITypeMachineEndPoint.READ_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> readTypeMachinery(@PathVariable Integer typeMachineryId) {
        return this.typeMachineryService.readTypeMachinery(typeMachineryId);
    }
    @Override
    @Operation(summary = "lee toda la maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ITypeMachineryResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ITypeMachineryResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(ITypeMachineEndPoint.READ_ALL_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> readAllMachineryForTypeWithMaintenance(Integer typeMachineId) {
        return this.typeMachineryService.readAllMachineryForTypeWithMaintenance(typeMachineId);
    }
    @Override
    @Operation(summary = "actualiza la maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ITypeMachineryResponse.UPDATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ITypeMachineryResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ITypeMachineryResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(ITypeMachineEndPoint.UPDATE_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> updateTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO) {
        return this.typeMachineryService.updateTypeMachinery(typeMachineryDTO);
    }
    @Override
    @Operation(summary = "elimina un tipo de maquinaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = ITypeMachineryResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = ITypeMachineryResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = ITypeMachineryResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(ITypeMachineEndPoint.DELETE_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> deleteTypeMachinery(@RequestBody TypeMachineryDTO typeMachineryDTO) {
        return this.typeMachineryService.deleteTypeMachinery(typeMachineryDTO);
    }
}