package fr.modded.api.server;

import java.util.UUID;

public interface IPlayerServer extends IServer, IInvitation {
    UUID getOwner();

    String getType();

    boolean isExpired();

    void setExpired(boolean expired);

    long getExpireTime();

    void setExpireTime(long expire);
}
