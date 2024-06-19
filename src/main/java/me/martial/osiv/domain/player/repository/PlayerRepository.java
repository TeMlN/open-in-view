package me.martial.osiv.domain.player.repository;

import me.martial.osiv.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
