package Samba.commons.domains.DTO.machine;

import lombok.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MachineDTO implements Serializable
{
    public Integer machineSambaId;
    public String machineName;
    public String machinePlate;
    public String machineFuel;
    public String machineColor;
    public Integer getMachineSambaId() {return machineSambaId;}
    public void setMachineSambaId(Integer machineSambaId) {this.machineSambaId = machineSambaId;}
    public String getMachineName() {return machineName;}
    public void setMachineName(String machineName) {this.machineName = machineName;}
    public String getMachinePlate() {return machinePlate;}
    public void setMachinePlate(String machinePlate) {this.machinePlate = machinePlate;}
    public String getMachineFuel() {return machineFuel;}
    public void setMachineFuel(String machineFuel) {this.machineFuel = machineFuel;}
    public String getMachineColor() {return machineColor;}
    public void setMachineColor(String machineColor) {this.machineColor = machineColor;}

}