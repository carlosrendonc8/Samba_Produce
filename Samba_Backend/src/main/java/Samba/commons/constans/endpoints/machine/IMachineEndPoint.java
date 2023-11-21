package Samba.commons.constans.endpoints.machine;

public interface IMachineEndPoint
{
    String BASE_URL_MACHINE = "/machine-conexion-web/api-vehicle/endpoint/machine";
    String CREATE_MACHINE = "/create";
    String READ_MACHINE = "/read{machineId}";
    String READ_ALL_MACHINE = "/readAll";
    String UPDATE_MACHINE = "/update";
    String DELETE_MACHINE = "/delete{machineId}";
    String READ_MACHINE_ID = "/readMachineId{machineId}";
}
