package team2umgc.eventreminder.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2umgc.eventreminder.entity.UserAccount;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByUserName(String username);
    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findUserByMobileNumber(String mobileNumber);
    Optional<UserAccount> findByUserNameOrEmail(String email, String username);
}

