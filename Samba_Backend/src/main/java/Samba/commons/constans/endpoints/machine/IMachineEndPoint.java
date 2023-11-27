package Samba.commons.constans.endpoints.machine;

public interface IMachineEndPoint
{
    String BASE_URL_MACHINE = "/machine";
    String CREATE_MACHINE = "/create";
    String READ_MACHINE_ID = "/readMachineId{machineSambaId}";
    String READ_ALL_MACHINE = "/read-all";
    String UPDATE_MACHINE = "/update";
    String DELETE_MACHINE = "/delete{machineId}";
}