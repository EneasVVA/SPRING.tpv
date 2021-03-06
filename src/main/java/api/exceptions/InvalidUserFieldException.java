package api.exceptions;

public class InvalidUserFieldException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "User field is empty or nonexisten";

    public static final int CODE = 2;

    public InvalidUserFieldException() {
        this("");
    }

    public InvalidUserFieldException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
