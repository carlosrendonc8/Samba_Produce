package Samba.commons.constans.endpoints.typeMachinery;

public interface ITypeMachineryEndPoint
{
    String BASE_URL_TYPE_MACHINERY = "/type-machinery";
    String CREATE_TYPE_MACHINERY = "/create";
    String READ_TYPE_MACHINERY = "/read{typeMachineryId}";
    String READ_ALL_TYPE_MACHINERY = "/read-all";
    String READ_ALL_MACHINES_ENABLE_FOR_TYPE_MACHINERY = "/read-all-machines-enable-for-type-machinery{typeMachineryId}";
    String DELETE_TYPE_MACHINERY = "/delete{typeMachineryId}";
}