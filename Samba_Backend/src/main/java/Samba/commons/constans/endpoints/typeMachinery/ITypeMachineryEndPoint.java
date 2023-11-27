package Samba.commons.constans.endpoints.typeMachinery;

public interface ITypeMachineEndPoint
{
    String BASE_URL_TYPE_MACHINERY = "/type-machinery";
    String CREATE_TYPE_MACHINERY = "/create";
    String READ_TYPE_MACHINERY = "/read-type-machinery{typeMachineryId}";
    String READ_ALL_TYPE_MACHINERY = "/read-all";
    String READ_ALL_MACHINERY_WITH_MAINTENANCE_FOR_TYPE_MACHINERY = "/machinery-with-maintenance-for-type-machinery{typeMachinaryId}";
    String UPDATE_TYPE_MACHINERY = "/update";
    String DELETE_TYPE_MACHINERY = "/delete{typeMachinaryId}";
}