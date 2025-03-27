interface MessagingService {
    void sendMessage(String message);
}

class EmailService implements MessagingService {
    public void sendMessage(String message) {
    // Email versturen via een specifieke provider
}
}

class UserRegistration {
    private MessagingService messagingService;

    // Afhankelijkheid wordt geïnjecteerd via constructor
    public UserRegistration(MessagingService messagingService) {
    this.messagingService = messagingService;
}

public void registerUser(String user) {
    // Gebruiker registreren en bevestigingsmail sturen
    messagingService.sendMessage("Welcome " + user);
}
}
