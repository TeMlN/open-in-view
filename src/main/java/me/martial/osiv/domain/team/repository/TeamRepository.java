package me.martial.osiv.domain.team.repository;

import me.martial.osiv.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
