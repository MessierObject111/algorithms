package com.java8.optional;

import com.java8.optional.pack.Computer;
import com.java8.optional.pack.Soundcard;
import com.java8.optional.pack.USB;
import com.java8.optional.pack.UsbStorage;

import java.util.Optional;

public class OptionalsTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Optional<Computer> optionalComputer = Optional.of(computer);
        Soundcard soundcard_0 = new Soundcard();
        computer.setSoundcard(soundcard_0);
        computer.setOptionalSoundcard(Optional.of(soundcard_0));
        // Null pointer exception
        try {
            String uuid = computer.getSoundcard()
                    .getUsb().getUsbStorage().getUsbVersion();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        // Safe way to check for each layer but verbose and unreadable
        String version = "UNKNOWN";
        if(computer != null){
            Soundcard soundcard = computer.getSoundcard();
            if(soundcard != null){
                USB usb = soundcard.getUsb();
                if(usb != null){
                    UsbStorage usbStorage = usb.getUsbStorage();
                    if(usbStorage!= null) {
                        version = usbStorage.getUsbVersion();
                    }
                }
            }
        }

        System.out.println("version:" + version);


        //Using Optional Class
//        String name = computer.flatMap(Computer::getSoundcard)
//                .flatMap(Soundcard::getUSB)
//                .map(USB::getVersion)
//                .orElse("UNKNOWN");

//        Optional<Soundcard> soundCard = computer.getOptionalSoundcard();
//        Optional<USB> usb = soundCard.flatMap(Soundcard::getOptionalUsb);
//        Optional<UsbStorage> usbStorage = usb.flatMap(USB::getOptionalUsbStorage);
//        String usbVersion = usbStorage.get().getUsbVersion();
//
//        System.out.println("usbVersion" + usbVersion);

        // To chain it, start with a concrete instance of Computer,
        // then get Optional wrapped intermediate instances like
        // Optional SoundCard, Optional Usb and UsbStorage, then convert
        // terminate optional result to real UsbStorage instance and get
        String usbVn = optionalComputer.flatMap(Computer::getOptionalSoundcard)
                .flatMap(Soundcard::getOptionalUsb)
                .flatMap(USB::getOptionalUsbStorage)
                .map(UsbStorage::getUsbVersion).orElse("UNKNOWN");
//                .get().getUsbVersion();

        System.out.println("usbVn" + usbVn);


        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

//        String optionalUuid = computer.getOptionalSoundcard().get()
//                .getOptionalUsb().get()
//                .getUsbVersion();
//
//        System.out.println("Optional version: "+ optionalUuid);
        System.out.println("Test ended.");
    }
}
