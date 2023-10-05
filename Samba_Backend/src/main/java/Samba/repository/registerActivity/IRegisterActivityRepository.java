package Samba.repository.registerActivity;

import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisterActivityRepository extends JpaRepository<RegisterActivityEntity, Integer> {
}