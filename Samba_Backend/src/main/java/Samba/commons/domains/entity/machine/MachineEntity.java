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
    private String machineBrand;

    @Column(name = "machine_accumulated_hours")
    private Integer machineAccumulatedHours;

    @Column(name = "machine_engine_oil_change", nullable = true)
    private String machineEngineOilChange;

    @Column(name = "machine_oil_filter_change", nullable = true)
    private String machineOilFilterChange;

    @Column(name = "machine_fuel_filter_change", nullable = true)
    private String machineFuelFilterChange;

    @Column(name = "machine_hydraulic_oil_change", nullable = true)
    private String machineHydraulicOilChange;

    @Column(name = "machine_differential_oil_change", nullable = true)
    private String machineDifferentialOilChange;

    @Column(name = "machine_front_axle_lubrication", nullable = true)
    private String machineFrontAxleLubrication;

    @Column(name = "machine_planetary_gear_oil_change", nullable = true)
    private String machinePlanetaryGearOilChange;

    @Column(name = "machine_rocker_lubrication", nullable = true)
    private String machineRockerLubrication;

    @Column(name = "machine_flannel_lubrication", nullable = true)
    private String machineFlannelLubrication;

    @Column(name = "machine_crosshead_lubrication", nullable = true)
    private String machineCrossheadLubrication;

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