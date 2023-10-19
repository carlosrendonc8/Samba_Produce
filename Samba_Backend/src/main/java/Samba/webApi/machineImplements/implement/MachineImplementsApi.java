package Samba.webApi.machineImplements.implement;

import Samba.commons.constans.endpoints.machine.IMachineEndPoint;
import Samba.commons.constans.endpoints.machineImplements.IMachineImplementsEndPoint;
import Samba.commons.constans.response.machine.IMachineResponse;
import Samba.commons.constans.response.machineImplements.IMachineImplementsResponse;
import Samba.commons.domains.DTO.responseDTO.GenericResponseDTO;
import Samba.service.machineImplements.implement.MachineImplementsService;
import Samba.webApi.machineImplements.IMachineImplementsApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IMachineImplementsEndPoint.BASE_URL_MACHINE_IMPLEMENTS)
@Tag( name = "Sistema de Datos de un CRUD para leer los Implementos de Maquinaria" , description = "Opcion de leer todos los implementos")
public class MachineImplementsApi implements IMachineImplementsApi {
    private final MachineImplementsService machineImplementsService;

    public MachineImplementsApi(MachineImplementsService machineImplementsService) {this.machineImplementsService = machineImplementsService;}
    @Override
    @Operation(summary = "lee toda los implementos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = IMachineImplementsResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode = "400", description = IMachineImplementsResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = IMachineImplementsResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = IMachineImplementsResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IMachineImplementsEndPoint.READ_ALL_IMPLEMENTS)
    public ResponseEntity<GenericResponseDTO> readAllImplements() {return this.machineImplementsService.readAllImplement();}
}