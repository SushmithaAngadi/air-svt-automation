package com.resideo.utils.aat;

public class AATManager {

    private static AatCommandHandler handler;

    public static void setHandler(AatCommandHandler h) {
        handler = h;
    }

    public static AatCommandHandler getHandler() {
        if (handler == null) {
            throw new IllegalStateException("AAT Handler not initialized. Connect serial port first.");
        }
        return handler;
    }
}