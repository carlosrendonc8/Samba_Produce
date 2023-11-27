
package Samba.webApi.typeMachinery.implement;

import Samba.commons.constans.endpoints.typeMachinery.ITypeMachineryEndPoint;
import Samba.commons.constans.response.typeMachinery.ITypeMachineryResponse;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import Samba.service.typeMachinery.implement.TypeMachineryService;
import Samba.webApi.typeMachinery.ITypeMachineryApi;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(ITypeMachineryEndPoint.BASE_URL_TYPE_MACHINERY)
@Tag( name = "Sistema de Datos de un CRUD de tipo de maquinaria" , description = "Opciones de crear, eliminar, actualizar y ver un tipo de maquinaria")
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
    @PostMapping(ITypeMachineryEndPoint.CREATE_TYPE_MACHINERY)
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
    @GetMapping(ITypeMachineryEndPoint.READ_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> readTypeMachinery(@PathVariable Integer typeMachineryId) {
        return this.typeMachineryService.readTypeMachinery(typeMachineryId);
    }

    @Override
    @GetMapping(ITypeMachineryEndPoint.READ_ALL_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> readAll(){
        return this.typeMachineryService.readAll();
    }

    @GetMapping(ITypeMachineryEndPoint.READ_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> bringAllMachinesEnablesForTypeMachine(@PathVariable Integer typeMachineryId) {
        return this.typeMachineryService.bringAllMachinesEnablesForTypeMachine(typeMachineryId);
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
    @DeleteMapping(ITypeMachineryEndPoint.DELETE_TYPE_MACHINERY)
    public ResponseEntity<GenericResponseDTO> deleteTypeMachinery(@PathVariable Integer typeMachineryId) {
        return this.typeMachineryService.deleteTypeMachinery(typeMachineryId);
    }
}