package Samba.commons.domains.entity.machine;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import Samba.commons.domains.entity.typeMachinery.TypeMachineryEntity;

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
    public Integer machineSambaId;
    @Column(name = "machine_name")
    public String machineName;
    @Column(name = "machine_plate")
    public String machinePlate;
    @Column(name = "machine_fuel")
    public String machineFuel;
    @Column(name = "machine_color")
    public String machineColor;
    @Column(name = "machine_brand")
    public String machineBrand;
    @ManyToOne()
    @JoinColumn(name = "type_machinary_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "typeMachinaryId")
    @JsonIgnore
    private TypeMachineryEntity typeMachineryEntity;
}