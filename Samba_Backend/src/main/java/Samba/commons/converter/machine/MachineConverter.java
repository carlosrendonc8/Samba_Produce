package Samba.commons.converter.machine;


import Samba.commons.constans.response.machine.IMachineResponse;
import Samba.commons.domains.DTO.machine.MachineDTO;
import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class MachineConverter {
    public MachineDTO convertMachineEntityToMachineDTO(MachineEntity machineEntity) {
        MachineDTO machineDTO = new MachineDTO();
        try {
            machineDTO = HelperMapper.modelMapper().map(machineEntity, MachineDTO.class);
        } catch (Exception e) {
            log.error(IMachineResponse.CREATE_FAIL + e);
        }
        return machineDTO;
    }

    public MachineEntity convertMachineDTOToMachineEntity(MachineDTO machineDTO) {
        MachineEntity machineEntity = new MachineEntity();
        try {
            machineEntity = HelperMapper.modelMapper().map(machineDTO, MachineEntity.class);
        } catch (Exception e) {
            log.error(IMachineResponse.CREATE_FAIL + e);
        }
        return machineEntity;
    }
}
