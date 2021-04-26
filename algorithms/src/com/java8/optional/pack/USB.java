package com.java8.optional.pack;

import java.util.Optional;

public class USB {
    UsbStorage usbStorage;
    Optional<UsbStorage> optionalUsbStorage;

    public UsbStorage getUsbStorage() {
        return usbStorage;
    }

    public void setUsbStorage(UsbStorage usbStorage) {
        this.usbStorage = usbStorage;
    }

    public Optional<UsbStorage> getOptionalUsbStorage() {
        return optionalUsbStorage;
    }

    public void setOptionalUsbStorage(Optional<UsbStorage> optionalUsbStorage) {
        this.optionalUsbStorage = optionalUsbStorage;
    }
}
