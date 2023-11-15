package Samba.commons.domains.DTO.typeMachinery;

import Samba.commons.domains.entity.machine.MachineEntity;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TypeMachineryDTO implements Serializable
{
    private Integer typeMachinaryId;
    private String typeMachinaryName;
    private String typeMachinaryMessage;
    public String typeMachinaryStatus;
    private List<MachineEntity> listMachineEntity;
}