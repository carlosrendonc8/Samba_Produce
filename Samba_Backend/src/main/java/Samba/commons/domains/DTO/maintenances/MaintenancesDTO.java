package Samba.commons.domains.DTO.maintenances;

import lombok.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MaintenancesDTO implements Serializable {
    private Integer maintenancesId;
    private String maintenancesName;
    private Integer maintenanceHours;
}