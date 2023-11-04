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
    public Integer maintenancesId;
    public String maintenancesName;
    public int maintenanceHours;
}