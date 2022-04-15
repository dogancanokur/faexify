package net.okur.faexify.user.repository;

import net.okur.faexify.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
