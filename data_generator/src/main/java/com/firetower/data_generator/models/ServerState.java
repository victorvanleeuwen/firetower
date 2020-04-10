package com.firetower.data_generator.models;

public class ServerState {

    // duration is an indicator how long the state will stay for a server,
    // every cycle the duration will decrease until it reaches zero.
    private int duration;

    private State state;


    public ServerState(int duration, State state) {
        this.duration = duration;
        this.state = state;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void reduceDuration(){
        this.duration = duration -1;
    }
}
