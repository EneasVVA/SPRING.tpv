package api.exceptions;

public class NotFoundProductCodeException extends ApiException {

    private static final long serialVersionUID = -5670907548890543981L;

    public static final String DESCRIPTION = "Product code provided not found";

    public static final int CODE = 7;

    public NotFoundProductCodeException() {
        this("");
    }

    public NotFoundProductCodeException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
