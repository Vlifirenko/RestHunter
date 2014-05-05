package resthunter.content.rest;

/**
 * Created by gorodechnyj on 16.02.14.
 */
public class ChangeTaskStatusRequest {
    public long status;

    public ChangeTaskStatusRequest(long status) {
        this.status = status;
    }
}
