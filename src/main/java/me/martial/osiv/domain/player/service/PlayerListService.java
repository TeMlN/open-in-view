package me.martial.osiv.domain.player.service;

import lombok.RequiredArgsConstructor;
import me.martial.osiv.domain.player.entity.Player;
import me.martial.osiv.domain.player.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
