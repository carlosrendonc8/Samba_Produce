package Samba.commons.converter.machineImplements;

import Samba.commons.constans.response.machine.IMachineResponse;
import Samba.commons.domains.DTO.machineImplements.MachineImplementsDTO;
import Samba.commons.domains.entity.machineImplements.MachineImplementsEntity;
import Samba.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MachineImplementsConverter {
    public MachineImplementsDTO convertMachineImplementsEntityToMachineImplementsDTO(MachineImplementsEntity machineImplementsEntity) {
        MachineImplementsDTO machineImplementsDTO = new MachineImplementsDTO();
        try {
            machineImplementsDTO = HelperMapper.modelMapper().map(machineImplementsEntity, MachineImplementsDTO.class);
        } catch (Exception e) {
            log.error(IMachineResponse.CREATE_FAIL + e);
        }
        return machineImplementsDTO;
    }

    public MachineImplementsEntity convertMachineImplementsDTOToMachineImplementsEntity(MachineImplementsDTO machineImplementsDTO) {
        MachineImplementsEntity machineImplementsEntity = new MachineImplementsEntity();
        try {
            machineImplementsEntity = HelperMapper.modelMapper().map(machineImplementsDTO, MachineImplementsEntity.class);
        } catch (Exception e) {
            log.error(IMachineResponse.CREATE_FAIL + e);
        }
        return machineImplementsEntity;
    }
}