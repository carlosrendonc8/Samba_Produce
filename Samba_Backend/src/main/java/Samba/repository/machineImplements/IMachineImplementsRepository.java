package Samba.repository.machineImplements;

import Samba.commons.domains.entity.machineImplements.MachineImplementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMachineImplementsRepository extends JpaRepository<MachineImplementsEntity, Integer> {}