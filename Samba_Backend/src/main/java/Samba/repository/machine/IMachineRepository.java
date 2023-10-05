package Samba.repository.machine;

import Samba.commons.domains.entity.machine.IAdapterMachine;
import Samba.commons.domains.entity.machine.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IMachineRepository extends JpaRepository<MachineEntity, Integer> {
    @Query(value =  "SELECT p.machine_id AS idMachine, p.machine_name AS nameMachine, p.machine_color AS colorMachine, p.machine_brand AS brandMachine\n" +
            "FROM type_machine_samba c\n" +
            "JOIN machine_samba p ON c.type_machinary_id = p.type_machinary_id WHERE c.type_machinary_id = :machineryId", nativeQuery = true)
    List<IAdapterMachine> listMachinery (@Param("machineryId") Integer machineryId);
}
