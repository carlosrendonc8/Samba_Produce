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

    @Column(name = "maintenances_type")
    private String maintenancesType;

    @Column(name = "maintenances_date")
    private String maintenancesDate;

    @Column(name = "maintenances_machine_name")
    private String maintenancesMachineName;
}