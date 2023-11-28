package Samba.webApi.registerActivity.implement;

import Samba.commons.constans.endpoints.registerActivity.IRegisterActivityEndPoint;
import Samba.commons.constans.response.registerActivity.IRegisterActivityResponse;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.responseDTO.GenericResponseDTO;
import Samba.service.registerActivity.implement.RegisterActivityService;
import Samba.webApi.registerActivity.IRegisterActivityApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IRegisterActivityEndPoint.BASE_URL_REGISTER_ACTIVITY)
@Tag( name = "Sistema de Datos de un CRUD de un Registro de Actividad" , description = "Opciones de crear, eliminar, actualizar y ver un registro de actividad")
public class RegisterActivityApi implements IRegisterActivityApi {

    @Autowired
    public RegisterActivityService registerActivityService;

    @Override
    @Operation(summary = "crea un registro de actividad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IRegisterActivityResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IRegisterActivityResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IRegisterActivityEndPoint.CREATE_REGISTER_ACTIVITY)
    public ResponseEntity<GenericResponseDTO> createRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO) {
        return this.registerActivityService.createRegisterActivity(registerActivityDTO);
    }

    @Override
    @Operation(summary = "leer registros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IRegisterActivityResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IRegisterActivityResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IRegisterActivityEndPoint.READ_REGISTER_ACTIVITY)
    public ResponseEntity<GenericResponseDTO> readRegisterActivity(@PathVariable Integer registerActivityId) {
        return this.registerActivityService.readRegisterActivity(registerActivityId);
    }

    @Override
    @Operation(summary = "lee todos los registros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IRegisterActivityResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IRegisterActivityResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IRegisterActivityEndPoint.READ_ALL_REGISTER_ACTIVITY)
    public ResponseEntity<GenericResponseDTO> readAllRegisterActivity() {
        return this.registerActivityService.readAllRegisterActivity();
    }

    @Override
    @Operation(summary = "actualiza los registros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IRegisterActivityResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IRegisterActivityResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping(IRegisterActivityEndPoint.UPDATE_REGISTER_ACTIVITY)
    public ResponseEntity<GenericResponseDTO> updateRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO) {
        return this.registerActivityService.updateRegisterActivity(registerActivityDTO);
    }

    @Override
    @Operation(summary = "elimina los registros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IRegisterActivityResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IRegisterActivityResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IRegisterActivityResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @DeleteMapping(IRegisterActivityEndPoint.DELETE_REGISTER_ACTIVITY)
    public ResponseEntity<GenericResponseDTO> deleteRegisterActivity(@RequestBody RegisterActivityDTO registerActivityDTO) {
        return this.registerActivityService.deleteRegisterActivity(registerActivityDTO);
    }
}