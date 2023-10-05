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
    @Column(name = "register_activity_id")
    public int registerActivityId;
    @Column(name = "register_activity_date")
    public LocalDate registerActivityDate;
    @Column(name = "register_activity_hours")
    public int registerActivityHours;
    @Column(name = "register_activity_kilometers")
    public int registerActivityKilometers;
    @Column(name = "register_activity_accumulated_kilometers")
    public int registerActivityAccumulatedKilometers;
    @Column(name = "register_activity_accumulated_hours")
    public int registerActivityAccumulatedHours;
    @Column(name = "register_activity_work_realized")
    public String registerActivityWorkRealized;
    @Column(name = "register_activity_site_work")
    public String registerActivitySiteWork;
    @Column(name = "register_activity_eventualities")
    public String registerActivityEventualities;
    @Column(name = "register_activity_implement_machine")
    public String registerActivityImplementMachine;
    @Column(name = "register_activity_gallons")
    public int registerActivityGallons;
}