package test.MOAIS.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(String userId);
    Optional<Users> findByNicknameAndDeleted(String nickname, boolean deleted);
}
