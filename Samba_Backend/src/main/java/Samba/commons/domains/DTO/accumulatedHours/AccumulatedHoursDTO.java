package Samba.commons.domains.DTO.accumulatedHours;

import lombok.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AccumulatedHoursDTO implements Serializable {

    public Integer accumulatedHoursId;

    public int accumulatedHoursMachine;

    public int accumulatedHoursHours;
}