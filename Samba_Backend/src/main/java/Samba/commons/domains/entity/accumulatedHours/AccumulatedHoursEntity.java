package Samba.commons.domains.entity.accumulatedHours;

import Samba.commons.domains.entity.machine.MachineEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accumulated_hours")
public class AccumulatedHoursEntity {
    @Id
    @Column(name = "accumulated_hours_id")
    public Integer accumulatedHoursId;

    @Column(name = "accumulated_hours_machine")
    public int accumulatedHoursMachine;

    @Column(name = "accumulated_hours_hours")
    public int accumulatedHoursHours;

    @OneToOne
    @JoinColumn( name = "machine_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "machineSambaId")
    private MachineEntity machineEntity;
}
