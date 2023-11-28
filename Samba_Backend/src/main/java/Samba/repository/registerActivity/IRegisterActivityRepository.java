package Samba.repository.registerActivity;

import org.springframework.data.jpa.repository.JpaRepository;

import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterActivityRepository extends JpaRepository<RegisterActivityEntity, Integer> {}