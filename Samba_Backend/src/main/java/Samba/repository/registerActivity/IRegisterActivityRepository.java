package Samba.repository.registerActivity;

import org.springframework.data.jpa.repository.JpaRepository;

import Samba.commons.domains.entity.registerActivity.RegisterActivityEntity;

public interface IRegisterActivityRepository extends JpaRepository<RegisterActivityEntity, Integer> {
}