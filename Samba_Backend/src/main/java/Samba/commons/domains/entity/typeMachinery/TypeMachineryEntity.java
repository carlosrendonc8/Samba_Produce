package Samba.commons.domains.entity.typeMachinery;

import jakarta.persistence.*;
import lombok.*;
import Samba.commons.domains.entity.machine.MachineEntity;
import java.util.List;

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
    @Column (name = "type_machinary_message")
    public String typeMachinaryMessage;
    @Column( name = "type_machinary_status")
    public String typeMachinaryStatus;
    @OneToMany(mappedBy = "typeMachineryEntity")
    private List<MachineEntity> listMachineEntity;
}