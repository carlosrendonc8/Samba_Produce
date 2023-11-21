
package Samba.commons.converter.typeMachinery;

import Samba.commons.constans.response.typeMachinery.ITypeMachineryResponse;
import Samba.commons.domains.DTO.typeMachinery.TypeMachineryDTO;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;
import Samba.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class TypeMachineryConverter
{
    public TypeMachineryDTO convertTypeMachineryEntityToTypeMachineryDTO(TypeMachineryEntity typeMachineryEntity) {
        TypeMachineryDTO typeMachineryDTO = new TypeMachineryDTO( );
        try {
            typeMachineryDTO = HelperMapper.modelMapper().map(typeMachineryEntity, TypeMachineryDTO.class);
        } catch (Exception e) {
            log.error(ITypeMachineryResponse.CREATE_FAIL + e);
        }
        return typeMachineryDTO;
    }
    public TypeMachineryEntity convertTypeMachineryDTOToTypeMachineryEntity(TypeMachineryDTO typeMachineDTO) {
        TypeMachineryEntity typeMachineryEntity = new TypeMachineryEntity();
        try {
            typeMachineryEntity = HelperMapper.modelMapper().map(typeMachineDTO, TypeMachineryEntity.class);
        } catch (Exception e) {
            log.error(ITypeMachineryResponse.CREATE_FAIL + e);
        }
        return typeMachineryEntity;
    }
}
