package Samba.commons.converter.registerActivity;

import Samba.commons.constans.response.registerActivity.IRegisterActivityResponse;
import Samba.commons.domains.DTO.registerActivity.RegisterActivityDTO;
import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import Samba.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RegisterActivityConverter {
    public RegisterActivityDTO convertRegisterActivityEntityToRegisterActivityDTO(RegisterActivityEntity registerActivityEntity) {
        RegisterActivityDTO registerActivityDTO = new RegisterActivityDTO();
        try {
            registerActivityDTO = HelperMapper.modelMapper().map(registerActivityEntity, RegisterActivityDTO.class);
        } catch (Exception e) {
            log.error(IRegisterActivityResponse.CREATE_FAIL + e);
        }
        return registerActivityDTO;
    }

    public RegisterActivityEntity convertRegisterActivityDTOToRegisterActivityEntity(RegisterActivityDTO registerActivityDTO) {
        RegisterActivityEntity registerActivityEntity = new RegisterActivityEntity();
        try {
            registerActivityEntity = HelperMapper.modelMapper().map(registerActivityDTO, RegisterActivityEntity.class);
        } catch (Exception e) {
            log.error(IRegisterActivityResponse.CREATE_FAIL + e);
        }
        return registerActivityEntity;
    }
}
