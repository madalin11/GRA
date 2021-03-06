package rep.PP.exceptions;

public class UsernameAlreadyExistsException extends Exception {
    private String username;

    public UsernameAlreadyExistsException(String username) {
        super(String.format("Username used !", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
