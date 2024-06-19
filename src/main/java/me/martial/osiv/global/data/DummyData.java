package me.martial.osiv.global.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import me.martial.osiv.domain.player.entity.Player;
import me.martial.osiv.domain.player.repository.PlayerRepository;
import me.martial.osiv.domain.team.entity.League;
import me.martial.osiv.domain.team.entity.Team;
import me.martial.osiv.domain.team.repository.TeamRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DummyData {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @PostConstruct
    private void generate() {
        Team chelsea = new Team(null, "Chelsea", League.EPL);
        Team barcelona = new Team(null, "Barcelona", League.LALIGA);
        Team juventus = new Team(null, "Juventus", League.SERIEA_A);
        Team psg = new Team(null, "PSG", League.LIGUE_1);
        Team leverkusen = new Team(null, "Leverkusen", League.BUDENSLIGA);

        List<Team> teams = List.of(
            chelsea, barcelona, juventus, psg, leverkusen
        );

        teamRepository.saveAll(teams);

        playerRepository.saveAll(List.of(
            new Player(null, "palmer", 7, chelsea),
            new Player(null, "jackson", 10, chelsea),

            new Player(null, "pedri", 13, barcelona),
            new Player(null, "gavi", 11, barcelona),

            new Player(null, "pogba", 16, juventus),
            new Player(null, "Kiesa", 7, juventus),

            new Player(null, "Kangin", 11, psg),
            new Player(null, "dembelle", 16, psg),

            new Player(null, "virtz", 7, leverkusen),
            new Player(null, "grimaldo", 18, leverkusen)
            )
        );
    }


}
