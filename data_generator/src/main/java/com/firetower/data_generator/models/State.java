package com.firetower.data_generator.models;

import com.google.common.collect.Sets;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;

public enum State {
    normal(90),
    hardwareissue(2),
    softwareissue(2),
    heavyLoad(2),
    off(2),
    malicous(2);

    private final Integer weight;

    State(Integer weight){
        this.weight = weight;
    }


    public Integer getWeight() {
        return weight;
    }
}
