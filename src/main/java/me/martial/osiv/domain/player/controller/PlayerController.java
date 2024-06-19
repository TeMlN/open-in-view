package me.martial.osiv.domain.player.controller;

import lombok.RequiredArgsConstructor;
import me.martial.osiv.domain.player.dto.PlayerDto;
import me.martial.osiv.domain.player.entity.Player;
import me.martial.osiv.domain.player.service.PlayerListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerListService playerListService;

    @GetMapping(value = "/v1/players")
    private List<Player> getPlayerListV1() {
        return playerListService.getPlayerListV1();

        /**
         * Specification: open-in-view: true
         *
         * Actual Result: 조회 성공.
         *
         *
         * Specification: open-in-view: false
         *
         * Actual Result: Resolved [org.springframework.http.converter.HttpMessageNotWritableException:
         * Could not write JSON: could not initialize proxy [me.martial.osiv.domain.team.entity.Team#1] - no Session]
         *
         * 세션이 닫혔기 때문에 Team 프록시를 조회하지 못해 Exception 발생
         */

    }

    @GetMapping(value = "/v2/players")
    private List<PlayerDto> getPlayerListV2() {
        return playerListService.getPlayerListV2();

        /**
         * Specification: open-in-view: true
         *
         * Actual Result: 조회 성공.
         *
         *
         * Specification: open-in-view: false
         *
         * Actual Result: 조회 성공.
         */
    }
}
