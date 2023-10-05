package Samba.repository.user;

import Samba.commons.domains.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}