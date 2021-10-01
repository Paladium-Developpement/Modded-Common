package fr.modded.api.model.admin;

public class AdminPlayerServerBackupModel extends AdminModel {
    private final String serverId;
    private final String backupId;

    public AdminPlayerServerBackupModel(String token, String playerId, String serverId, String backupId) {
        super(token, playerId);
        this.serverId = serverId;
        this.backupId = backupId;
    }

    public String getServerId() {
        return serverId;
    }

    public String getBackupId() {
        return backupId;
    }
}
