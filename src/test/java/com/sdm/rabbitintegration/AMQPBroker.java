package com.sdm.rabbitintegration;

import lombok.extern.slf4j.Slf4j;
import org.apache.qpid.server.SystemLauncher;
import org.apache.qpid.server.model.SystemConfig;

import java.util.HashMap;

@Slf4j
public class AMQPBroker implements AutoCloseable {

    private static final String CONFIG_TYPE = "Memory";

    private final int port;
    private final SystemLauncher launcher;


    public AMQPBroker(int port) {
        this.port = port;
        this.launcher = new SystemLauncher();
    }

    public void start() throws Exception {
        final String config = AMQPBroker.class.getClassLoader().getResource("qpid.json").toExternalForm();
        log.info(config);
        this.launcher.startup(new HashMap<String, Object>(){{
            put(SystemConfig.INITIAL_SYSTEM_PROPERTIES_LOCATION, config);
            put(SystemConfig.TYPE, CONFIG_TYPE);
            put(SystemConfig.STARTUP_LOGGED_TO_SYSTEM_OUT, true);
        }});
    }

    @Override
    public void close() {
        this.launcher.shutdown();
    }
}
