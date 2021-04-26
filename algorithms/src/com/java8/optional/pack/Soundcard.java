package com.java8.optional.pack;

import java.util.Optional;

public class Soundcard {
    USB usb;
    Optional<USB> optionalUsb;

    public USB getUsb() {
        return usb;
    }

    public void setUsb(USB usb) {
        this.usb = usb;
    }

    public Optional<USB> getOptionalUsb() {
        return optionalUsb;
    }

    public void setOptionalUsb(Optional<USB> optionalUsb) {
        this.optionalUsb = optionalUsb;
    }
}
