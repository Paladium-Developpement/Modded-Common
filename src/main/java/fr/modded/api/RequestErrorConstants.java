package fr.modded.api;

public class RequestErrorConstants {
    public static final String INTERNAL_ERROR = "InternalErrorException";

    public static final String NOT_FOUND = "NotFoundException";
    public static final String BAD_REQUEST = "BadRequestException";
    public static final String RATE_LIMIT = "RateLimitException";

    /**
     * User
     */
    public static final String INVALID_PLAYER = "InvalidPlayerException";
    public static final String BANNED_PLAYER = "BannedPlayerException";
    public static final String INVALID_PLAYER_SESSION = "InvalidPlayerSessionException";

    // Friend
    public static final String ALREADY_FRIEND = "AlreadyFriendException";
    public static final String ALREADY_INVITE_FRIEND = "AlreadyInviteFriendException";
    public static final String INVALID_FRIEND = "InvalidFriendException";
    public static final String DISABLE_FRIEND = "DisableFriendException";

    // Mojang
    public static final String INVALID_CREDENTIALS = "InvalidCredentialsException";

    // Server
    public static final String INVALID_SERVER = "InvalidServerException";
    public static final String INVALID_INVITATION_CODE = "InvalidInvitationCodeException";
    public static final String LIMITED_INVITATION_CODE = "LimitedInvitationCodeException";
    public static final String EXPIRED_SERVER = "ExpiredServerException";

    // Server Whitelist
    public static final String WHITELIST = "WhiteListException";
    public static final String ALREADY_WHITELIST = "AlreadyWhitelistException";
    public static final String INVITATION = "InvitationException";

    /**
     * Admin
     */
    public static final String PERMISSIONS = "PermissionsException";
}
