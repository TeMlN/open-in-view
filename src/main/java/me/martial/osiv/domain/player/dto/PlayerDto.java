package me.martial.osiv.domain.player.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.martial.osiv.domain.team.entity.League;
import me.martial.osiv.domain.team.entity.Team;

@Getter
@AllArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private Integer number;
    private Team team;

    @Getter
    @AllArgsConstructor
    public static class Team {
        private Long id;
        private String name;
        private League league;
    }
}
