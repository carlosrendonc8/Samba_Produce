package Samba.commons.domains.entity.registerActivity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "register_activity_samba")
public class RegisterActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_activity_id")
    private int registerActivityId;
    @Column(name = "register_activity_date")
    private LocalDate registerActivityDate;
    @Column(name = "register_activity_hours")
    private int registerActivityHours;
    @Column(name = "register_activity_work_realized")
    private String registerActivityWorkRealized;
    @Column(name = "register_activity_site_work")
    private String registerActivitySiteWork;
    @Column(name = "register_activity_eventualities")
    private String registerActivityEventualities;
    @Column(name = "register_activity_implement_machine")
    private String registerActivityImplementMachine;
    @Column(name = "register_activity_machine_id")
    private String registerActivityMachineId;
}