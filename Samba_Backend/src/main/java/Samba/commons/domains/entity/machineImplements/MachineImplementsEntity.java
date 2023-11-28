package Samba.commons.domains.entity.machineImplements;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "machine_implements")
public class MachineImplementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_implement_id")
    public Integer machineImplementId;
    @Column(name = "machine_implement_name")
    public String machineImplementName;
}
