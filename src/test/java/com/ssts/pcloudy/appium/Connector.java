package com.ssts.pcloudy.appium;

import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;

/**
 * Stub class for pCloudy SDK's Connector.
 * Provides compilation support when the pCloudy SDK is unavailable.
 */
public class Connector {

    public String executeAdbCommand(String authToken, BookingDtoDevice device, String command) {
        throw new UnsupportedOperationException("pCloudy SDK is not available. Install the actual SDK for runtime usage.");
    }
}
