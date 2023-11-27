package Samba.repository.machine;

import Samba.commons.domains.entity.machine.IAdapterMachine;
import Samba.commons.domains.entity.machine.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IMachineRepository extends JpaRepository<MachineEntity, Integer> {
}
