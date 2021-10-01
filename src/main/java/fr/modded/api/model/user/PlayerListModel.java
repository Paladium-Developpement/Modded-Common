package fr.modded.api.model.user;

import java.util.List;

public class PlayerListModel {
    private final List<PlayerInfoModel> players;

    public PlayerListModel(List<PlayerInfoModel> players) {
        this.players = players;
    }

    public List<PlayerInfoModel> getPlayers() {
        return players;
    }
}
