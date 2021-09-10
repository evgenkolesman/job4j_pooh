package pooh.service;

import pooh.Req;
import pooh.Resp;

/**
 * Services interface
 *
 * @Kolesnikov Evgeniy
 * @version 1.0
 */
public interface Service {
    Resp process(Req req);
}
