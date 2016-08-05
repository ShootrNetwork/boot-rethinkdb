package com.shootr.db;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RethinkDBConnectionFactory {
    private String host;


    public RethinkDBConnectionFactory(String host) {
        this.host = host;
    }

    public Connection createConnection() {
        System.out.println("Initializing RethinkDBConnectionFactory. Host: "+host);
        return RethinkDB.r.connection().hostname(host).connect();
    }
}
