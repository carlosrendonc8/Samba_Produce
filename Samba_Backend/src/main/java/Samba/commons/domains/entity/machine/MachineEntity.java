package Samba.commons.domains.entity.machine;
import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "machine_samba")
public class MachineEntity
{
    @Id
    @Column(name = "machine_id")
    private Integer machineSambaId;
    @Column(name = "machine_name")
    private String machineName;
    @Column(name = "machine_plate")
    private String machinePlate;
    @Column(name = "machine_fuel")
    private String machineFuel;
    @Column(name = "machine_color")
    private String machineColor;
    @Column(name = "machine_brand")
    public String machineBrand;
    @Column(name = "machine_accumulated_hours", nullable = true)
    private Integer machineAccumulatedHours;
    @ManyToOne()
    @JoinColumn(name = "type_machinary_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "typeMachinaryId")
    @JsonIgnore
    private TypeMachineryEntity typeMachineryEntity;

    /*
    @OneToMany(mappedBy = "machineEntity")
    public List<RegisterActivityEntity> listRegisterActivity;
     */
}