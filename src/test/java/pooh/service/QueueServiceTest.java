package pooh.service;

import org.junit.Assert;
import org.junit.Test;
import pooh.Req;

import static org.hamcrest.Matchers.is;

public class QueueServiceTest {

    @Test
    public void postQueueTestWrongPost() {
        QueueService queueService = new QueueService();
        Req req = Req.of("POST /topic/weather -d temperature=18");

        Assert.assertThat(queueService.process(req).text(), is("BadRequest"));
        Assert.assertThat(queueService.process(req).status(), is(400));
    }

    @Test
    public void getQueueTestWrongGet() {
        QueueService queueService = new QueueService();
        Req req = Req.of("GET /topic/weather/1");

        Assert.assertThat(queueService.process(req).text(), is("BadRequest"));
        Assert.assertThat(queueService.process(req).status(), is(400));
    }

    @Test
    public void postQueueTest() {
        QueueService queueService = new QueueService();
        Req req = Req.of("POST /queue/weather -d temperature=18");

        Assert.assertThat(queueService.process(req).text(), is("OK"));
        Assert.assertThat(queueService.process(req).status(), is(200));
    }

    @Test
    public void getQueueTest() {
        QueueService queueService = new QueueService();
        Req req = Req.of("GET /queue/weather");

        Assert.assertThat(queueService.process(req).status(), is(200));
    }

    @Test
    public void postQueueTestTwoReq() {
        QueueService queueService = new QueueService();
        Req req = Req.of("POST /queue/weather -d temperature=18");
        Req req2 = Req.of("POST /queue/weather -d pressure=400");
        queueService.process(req);
        Assert.assertThat(queueService.process(req2).text(), is("OK"));
        Assert.assertThat(queueService.process(req2).status(), is(200));
    }

    @Test
    public void postQueueTestTwoReqAndWrong() {
        QueueService queueService = new QueueService();
        Req req = Req.of("POST /queue/weather -d temperature=18");
        Req req2 = Req.of("POST /queue/weather -d pressure=400");
        Req req3 = Req.of("POST /topic/weather -d temperature=18");
        queueService.process(req);
        queueService.process(req2);
        Assert.assertThat(queueService.process(req3).status(), is(400));
    }

    @Test
    public void getQueueTestTwoReqAndWrong() {
        QueueService queueService = new QueueService();
        Req req = Req.of("GET /queue/weather");
        Req req2 = Req.of("GET /queue/weather");
        Req req3 = Req.of("GET /topic/weather");
        queueService.process(req);
        queueService.process(req2);
        Assert.assertThat(queueService.process(req3).status(), is(400));
    }
}