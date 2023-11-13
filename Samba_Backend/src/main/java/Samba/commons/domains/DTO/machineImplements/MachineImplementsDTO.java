package Samba.commons.domains.DTO.machineImplements;

import lombok.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MachineImplementsDTO implements Serializable {
    private Integer machineImplementId;
    private String machineImplementName;
}