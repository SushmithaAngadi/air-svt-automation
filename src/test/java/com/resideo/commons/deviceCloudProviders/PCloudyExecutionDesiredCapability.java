package com.resideo.commons.deviceCloudProviders;

import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;

/**
 * Local override of Core_Framework's PCloudyExecutionDesiredCapability.
 * Adds missing methods (getpCloudySession, getBookingDtoDevice) that the
 * project code expects but are not present in Core_Framework 1.0.1.
 */
public class PCloudyExecutionDesiredCapability {

    public final class PCloudyDeviceInformation {
        private String authToken;
        private PCloudyAppiumSession pCloudySession;
        private BookingDtoDevice bookingDtoDevice;

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }

        public String getAuthToken() {
            return this.authToken;
        }

        public PCloudyAppiumSession getpCloudySession() {
            return this.pCloudySession;
        }

        public void setpCloudySession(PCloudyAppiumSession session) {
            this.pCloudySession = session;
        }

        public BookingDtoDevice getBookingDtoDevice() {
            return this.bookingDtoDevice;
        }

        public void setBookingDtoDevice(BookingDtoDevice device) {
            this.bookingDtoDevice = device;
        }
    }
}
