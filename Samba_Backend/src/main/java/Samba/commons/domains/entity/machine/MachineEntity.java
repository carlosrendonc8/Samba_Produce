package Samba.commons.domains.entity.machine;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "machine_samba")
public class MachineEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "machine_type")
    private String machineType;

    @Column(name = "machine_accumulated_hours")
    private Integer machineAccumulatedHours;

    @Column(name = "machine_engine_oil_change")
    private String machineEngineOilChange;

    @Column(name = "machine_oil_filter_change")
    private String machineOilFilterChange;

    @Column(name = "machine_fuel_filter_change")
    private String machineFuelFilterChange;

    @Column(name = "machine_hydraulic_oil_change")
    private String machineHydraulicOilChange;

    @Column(name = "machine_differential_oil_change")
    private String machineDifferentialOilChange;

    @Column(name = "machine_front_axle_lubrication")
    private String machineFrontAxleLubrication;

    @Column(name = "machine_planetary_gear_oil_change")
    private String machinePlanetaryGearOilChange;

    @Column(name = "machine_rocker_lubrication")
    private String machineRockerLubrication;

    @Column(name = "machine_flannel_lubrication")
    private String machineFlannelLubrication;

    @Column(name = "machine_crosshead_lubrication")
    private String machineCrossheadLubrication;

    /*
    @ManyToOne()
    @JoinColumn(name = "type_machinary_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "typeMachinaryId")
    @JsonIgnore
    private TypeMachineryEntity typeMachineryEntity;

    @OneToMany(mappedBy = "machineEntity")
    public List<RegisterActivityEntity> listRegisterActivity;
    */
}