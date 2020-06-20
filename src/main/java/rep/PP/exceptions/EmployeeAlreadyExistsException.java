package rep.PP.exceptions;

public class EmployeeAlreadyExistsException extends Exception {
    private String CNP;

    public EmployeeAlreadyExistsException(String CNP ) {
        super(String.format("Employee found !", CNP));
        this.CNP = CNP;

    }

    public String getCNP() {
        return CNP;
    }


}