package Samba.commons.domains.entity.typeMachinery;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "type_machine_samba")
public class TypeMachineryEntity
{
    @Id
    @Column(name = "type_machinary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer typeMachinaryId;
    @Column(name = "type_machinary_name")
    public String typeMachinaryName;
    /*
    @OneToMany(mappedBy = "typeMachineryEntity")
    private List<MachineEntity> listMachineEntity;
    */
}