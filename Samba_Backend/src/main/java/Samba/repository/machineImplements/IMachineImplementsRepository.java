package Samba.repository.machineImplements;

import Samba.commons.domains.entity.machine.MachineEntity;
import Samba.commons.domains.entity.machineImplements.MachineImplementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMachineImplementsRepository extends JpaRepository<MachineImplementsEntity, Integer> {
}