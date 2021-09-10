package pooh;

/**
 * Response method
 * makes response
 *
 * @status - status numbere
 * @text - response`s text
 * @Kolesnikov Evgeniy
 * version 1.0
 */
public class Resp {
    private final String text;
    private final int status;

    public Resp(String text, int status) {
        this.text = text;
        this.status = status;
    }

    public String text() {
        return text;
    }

    public int status() {
        return status;
    }
}
