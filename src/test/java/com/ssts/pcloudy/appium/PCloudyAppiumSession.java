package com.ssts.pcloudy.appium;

/**
 * Stub class for pCloudy SDK's PCloudyAppiumSession.
 * The actual pCloudy Java Connector SDK is required at runtime for pCloudy device cloud testing.
 * This stub allows compilation when the SDK is not available in the Maven repository.
 */
public class PCloudyAppiumSession {
    
    private Connector connector;

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }
}
