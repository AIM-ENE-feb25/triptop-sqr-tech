### Hoe kunnen we verschillende identity providers met verschillende interfaces integreren voor het gehele systeem?

#### Componenten

- IdentityProvider
    - De identity provider is verantwoordelijk voor het authenticeren van de gebruiker.
- AuthenticationManager
    - De authentication manager is verantwoordelijk voor het aansturen van de identity provider.
- TokenProvider
    - De token provider valideert/creeërt tokens voor de gebruiker.
- UserManager
    - De user manager is verantwoordelijk voor het beheren van de gebruikers.

```java
interface IdentityProvider {
  String getProviderID();
  void authenticate(String username, String password);
}

interface AuthenticationManager {
  String login(String password, String userPassword);
  String TokenProvider.createToken(String username, String password);
}

interface TokenProvider {

  String createToken(String username);

  boolean validateToken(String token);
}

interface UserManager {

User getUser(String userId);

void addUser(String username, String password);

void removeUser(String username);
}
```

