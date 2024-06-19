package me.martial.osiv.domain.player.service;

import lombok.RequiredArgsConstructor;
import me.martial.osiv.domain.player.dto.PlayerDto;
import me.martial.osiv.domain.player.entity.Player;
import me.martial.osiv.domain.player.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerListService {

    private final PlayerRepository playerRepository;

    @Transactional(readOnly = true)
    public List<Player> getPlayerListV1() {
        List<Player> playerList = playerRepository.findAll();
        return playerList;
    }

    @Transactional(readOnly = true)
    public List<PlayerDto> getPlayerListV2() {
        /**
         * Data JPA, Querydsl Projection은 귀찮아서 사용하지 않음
         * 프로젝트에선 위 Projection을 사용하는것을 권장함.
         */
        List<Player> playerList = playerRepository.findAll();

        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player player : playerList) {
            playerDtoList.add(new PlayerDto(
                    player.getId(),
                    player.getName(),
                    player.getNumber(),
                    new PlayerDto.Team(
                            player.getTeam().getId(),
                            player.getTeam().getName(),
                            player.getTeam().getLeague()
                    )
            ));
        }

        return playerDtoList;
    }
}
