package ezen.com.esmall.repository;

import ezen.com.esmall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String uid);
    Optional<User> findByUidAndEmail(String uid, String email);
    Optional<User> findByNameAndEmail(String name, String email);
}
