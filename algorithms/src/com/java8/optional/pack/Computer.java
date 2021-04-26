package com.java8.optional.pack;

import java.util.Optional;

public class Computer {

    Soundcard soundcard;
    Optional<Soundcard> optionalSoundcard;

    public Computer() {
    }

    public Soundcard getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(Soundcard soundcard) {
        this.soundcard = soundcard;
    }

    public Optional<Soundcard> getOptionalSoundcard() {
        return optionalSoundcard;
    }

    public void setOptionalSoundcard(Optional<Soundcard> optionalSoundcard) {
        this.optionalSoundcard = optionalSoundcard;
    }
}
