package Samba.commons.domains.DTO.registerActivity;

import Samba.commons.domains.entity.machine.MachineEntity;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterActivityDTO implements Serializable {
    private Integer registerActivityId;
    private LocalDate registerActivityDate;
    private Integer registerActivityHours;
    private String registerActivityWorkRealized;
    private String registerActivitySiteWork;
    private String registerActivityEventualities;
    private String registerActivityImplementMachine;
    private Integer registerActivityMachineId;
}