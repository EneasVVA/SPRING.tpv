package api.exceptions;

public class NotFoundProductCodeInTicketException extends ApiException {

    private static final long serialVersionUID = 8019654584133930287L;

    public static final String DESCRIPTION = "El código de producto no se ha encontrado en el ticket";

    public static final int CODE = 14;

    public NotFoundProductCodeInTicketException() {
        this("");
    }

    public NotFoundProductCodeInTicketException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
