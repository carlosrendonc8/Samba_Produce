package Samba.commons.constans.endpoints.maintenance;

public interface IMaintenanceEndPoint {
    String BASE_URL_MAINTENANCE = "/maintenance";
    String CREATE_MAINTENANCE = "/create";
    String READ_MAINTENANCE = "/read{maintenancesId}";
    String READ_ALL_MAINTENANCE = "/readAll";
    String UPDATE_MAINTENANCE = "/update";
    String DELETE_MAINTENANCE = "/delete";
    String THERE_IS_MAINTENANCE = "/maintenance-type-machine";
}
