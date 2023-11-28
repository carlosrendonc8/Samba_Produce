package Samba.repository.machine;

import Samba.commons.domains.entity.machine.IAdapterMachine;
import Samba.commons.domains.entity.machine.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMachineRepository extends JpaRepository<MachineEntity, Integer> {}
