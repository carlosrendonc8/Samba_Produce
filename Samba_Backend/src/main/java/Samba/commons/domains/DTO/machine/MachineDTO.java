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
    private Integer machineSambaId;
    private String machineName;
    private String machinePlate;
    private String machineFuel;
    private String machineColor;
    private Integer machineAccumulatedHours;
}