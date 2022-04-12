package com.example.lab10;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends Connection {

    private String ip;
    private int port;

    public Client(String ip, int port, Consumer<Serializable> onReceiveCallBack) {
        super(onReceiveCallBack);
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return this.ip;
    }

    @Override
    protected int getPort() {
        return this.port;
    }
}
