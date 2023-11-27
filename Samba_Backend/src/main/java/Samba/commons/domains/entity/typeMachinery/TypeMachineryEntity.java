package Samba.commons.domains.entity.typeMachinery;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "type_machinery")
public class TypeMachineryEntity
{
    @Id
    @Column(name = "type_machinery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer typeMachineryId;
    @Column(name = "type_machinery_name")
    public String typeMachineryName;
    /*
    @OneToMany(mappedBy = "typeMachineryEntity")
    private List<MachineEntity> listMachineEntity;
    */
}