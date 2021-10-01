package fr.modded.api.server;

public class ServerInfo {
    private static final int MAX_NAME_LENGHT = 25;
    private static final int MAX_DESCRIPTION_LENGHT = 1500;

    private String name;
    private String description;
    private int bannerId;

    public ServerInfo() {
    }

    public ServerInfo(String name, String description, int bannerId) {
        this.name = name;
        this.description = description;
        this.bannerId = bannerId;
    }

    public void copy(final ServerInfo info) {
        if (info.getName() != null)
            this.name = info.getName();
        if (info.getDescription() != null)
            this.description = info.getDescription();
        if (info.getBannerId() != 0)
            this.bannerId = info.getBannerId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValideName() {
        if (this.name == null)
            return true;
        final String name = this.name.trim();
        return !name.isEmpty() && name.length() <= MAX_NAME_LENGHT;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValideDescription() {
        if (this.description == null)
            return true;
        final String description = this.description.trim();
        return !description.isEmpty() && description.length() <= MAX_DESCRIPTION_LENGHT;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public boolean isValideServerInfo() {
        return isValideName() && isValideDescription();
    }
}
