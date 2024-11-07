package team2umgc.eventreminder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2umgc.eventreminder.entity.ActivityType;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {
}
