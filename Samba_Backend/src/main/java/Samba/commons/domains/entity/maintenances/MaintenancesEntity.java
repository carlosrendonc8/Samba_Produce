package Samba.commons.domains.entity.maintenances;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "maintenances")
public class MaintenancesEntity {
    @Id
    @Column(name = "maintenances_id")
    public Integer maintenancesId;

    @Column(name = "maintenances_name")
    public String maintenancesName;

    @Column(name = "maintenances_hours")
    public int maintenanceHours;
}