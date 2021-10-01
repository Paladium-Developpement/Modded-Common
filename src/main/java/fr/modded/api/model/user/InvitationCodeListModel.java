package fr.modded.api.model.user;

import fr.modded.api.server.InvitationCode;

import java.util.List;

public class InvitationCodeListModel {
    private final List<InvitationCode> invitationCodes;

    public InvitationCodeListModel(List<InvitationCode> invitationCodes) {
        this.invitationCodes = invitationCodes;
    }

    public List<InvitationCode> getInvitationCodes() {
        return invitationCodes;
    }
}
