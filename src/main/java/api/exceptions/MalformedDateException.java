package api.exceptions;

public class MalformedDateException extends ApiException {
    private static final long serialVersionUID = 5296507526454478261L;

    public static final String DESCRIPTION = "Wrong format in sent date";

    public static final int CODE = 16;

    public MalformedDateException(String rightDateFormat, String detail) {
        super(DESCRIPTION + ". " + "Debe usarse el formato: " + rightDateFormat + ". " + detail, CODE);
    }

}
