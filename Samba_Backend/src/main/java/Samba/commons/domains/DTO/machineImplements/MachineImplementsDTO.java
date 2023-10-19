package Samba.commons.domains.DTO.machineImplements;

import lombok.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MachineImplementsDTO implements Serializable {
    public Integer machineImplementId;
    public String machineImplementName;

    public Integer getMachineImplementId() {return machineImplementId;}
    public void setMachineImplementId(Integer machineImplementId) {this.machineImplementId = machineImplementId;}


    public String getMachineImplementName() {return machineImplementName;}
    public void setMachineImplementName(String machineImplementName) {this.machineImplementName = machineImplementName;}
}