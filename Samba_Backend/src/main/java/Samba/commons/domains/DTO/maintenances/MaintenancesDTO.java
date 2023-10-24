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

    public Integer getMaintenancesId() {return maintenancesId;}
    public void setMaintenancesId(Integer maintenancesId) {this.maintenancesId = maintenancesId;}

    public String getMaintenancesName() {return maintenancesName;}
    public void setMaintenancesName(String maintenancesName) {this.maintenancesName = maintenancesName;}

    public int getMaintenanceHours() {return maintenanceHours;}
    public void setMaintenanceHours(int maintenanceHours) {this.maintenanceHours = maintenanceHours;}
}
