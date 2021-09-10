package pooh;

import java.text.MessageFormat;

/**
 * Request method
 * parses request
 * @method - method of rerquest Post or Get
 * @mode - type of service/type of message
 * @text - request`s text
 *
 * @Kolesnikov Evgeniy
 * version 1.0
 */
public class Req {

    private final String method;
    private final String mode;
    private final String text;

    private Req(String method, String mode, String text) {
        this.method = method;
        this.mode = mode;
        this.text = text;
    }

    public static Req of(String content) {
        String method = content.split(" ")[0];
        String mode = content.split( " ")[1];
        String text = "";

        if (method.equals("POST")) {
        text = content.split(" ")[3]; }

        return new Req(method, mode, text);
    }

    public String method() {
        return method;
    }

    public String mode() {
        return mode;
    }

    public String text() {
        return text;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Req'{'method=''{0}'', mode=''{1}'', text=''{2}'''}'",
                method, mode, text);
    }
}
