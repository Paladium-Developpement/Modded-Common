package fr.modded.api.model.admin;

public class AdminTargetServerModel extends AdminModel {
    private final String serverId;

    public AdminTargetServerModel(String token, String serverId) {
        super(token);
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }
}
