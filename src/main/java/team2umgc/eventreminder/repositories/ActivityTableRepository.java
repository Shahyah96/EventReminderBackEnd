package team2umgc.eventreminder.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2umgc.eventreminder.entity.ActivityTable;

@Repository
public interface ActivityTableRepository extends JpaRepository<ActivityTable, Integer> {
}

