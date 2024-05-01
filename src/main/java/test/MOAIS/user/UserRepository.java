package test.MOAIS.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(String userId);
    Optional<Users> findByNickname(String nickname);
    Optional<Users> findOneWithAuthoritiesByUserId(String userId);
}
