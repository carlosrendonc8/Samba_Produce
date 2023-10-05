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
    public Integer typeMachinaryId;
    public String typeMachinaryName;
    public String typeMachinaryMessage;
    public String typeMachinaryStatus;
    private List<MachineEntity> listMachineEntity;

    public Integer getTypeMachinaryId() {
        return typeMachinaryId;
    }

    public List<MachineEntity> getListMachineEntity() {
        return listMachineEntity;
    }

    public void setListMachineEntity(List<MachineEntity> listMachineEntity) {
        this.listMachineEntity = listMachineEntity;
    }

    public Integer getTypeMachineryId() {
        return typeMachinaryId;
    }
    public void setTypeMachinaryId(Integer typeMachineryId) {
        this.typeMachinaryId = typeMachineryId;
    }
    public String getTypeMachinaryName() {
        return typeMachinaryName;
    }
    public void setTypeMachinaryName(String typeMachinaryName) {this.typeMachinaryName = typeMachinaryName;}

    public String getTypeMachinaryMessage() {return typeMachinaryMessage;}

    public void setTypeMachinaryMessage(String typeMachinaryMessage) {this.typeMachinaryMessage = typeMachinaryMessage;}
    public String getTypeMachinaryStatus() {return typeMachinaryStatus;}
    public void setTypeMachinaryStatus(String typeMachinaryStatus) {this.typeMachinaryStatus = typeMachinaryStatus;}
}