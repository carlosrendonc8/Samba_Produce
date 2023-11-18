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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenances_id")
    private Integer maintenancesId;

    @Column(name = "maintenance_type")
    private String maintenancesType;

    @Column(name = "maintenance_date")
    private String maintenanceDate;

    @Column(name = "maintenance_machine_name")
    private String maintenanceMachineName;
}