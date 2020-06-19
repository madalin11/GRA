package rep.PP.exceptions;

public class UsernameDoesNotAlreadyExistsException extends Exception {
    private String username;

    public UsernameDoesNotAlreadyExistsException(String username) {
        super(String.format("Invalid Username !", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
