package fr.modded.api.server;

import fr.modded.api.util.list.LockList;

public interface IInvitation {
    LockList<String> getInvitationCodes();

    int getCurrentInvitations();

    void setCurrentInvitations(int value);

    void incrementInvitations(int amount);

    void decrementInvitations(int amount);
}
