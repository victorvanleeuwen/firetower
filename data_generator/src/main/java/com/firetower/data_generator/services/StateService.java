package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Server;
import com.firetower.data_generator.models.ServerState;
import com.firetower.data_generator.models.State;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

public class StateService {


    public static  Map<Server,ServerState> setup(List<Server> servers){

        HashMap<Server,ServerState> result = new HashMap<Server,ServerState>();


        for (Server server: servers) {

            result.put(server,pickWeightedRandom());
        }

        return result;
    }
    private static ServerState pickWeightedRandom(){

        Random randomGenerator = new Random();
        Integer sumOfWeight = 0;
        for (State state:State.values()) {
            sumOfWeight +=state.getWeight();
        }

        int randomInteger = randomGenerator.nextInt(sumOfWeight);

        for (State state:State.values()) {
            if( randomInteger < state.getWeight()){

                int randomDuration =randomGenerator.nextInt(60);

                ServerState serverState = new ServerState(randomDuration,state);
                return serverState;
            }
            else {
                randomInteger -= state.getWeight();
            }
        }
        // should never get here;
        return null;
    }
    
    public static Map<Server,ServerState> cycle(Map<Server,ServerState> input){


        for (Map.Entry<Server,ServerState> keyvalue: input.entrySet()) {

            keyvalue.getValue().reduceDuration();

            if(keyvalue.getValue().getDuration() == 0){

//
//                int AmountOfInfected = 0;
//
//                //check if there are more servers from the same user that are infected
//                for(Map.Entry<Server,ServerState> pointer: input.entrySet()){
//
//                    if(pointer.getKey().getUserId() == keyvalue.getKey().getUserId()){
//                        if(pointer.getValue().getState()== State.malicous){
//                            AmountOfInfected ++;
//                        }
//                    }
//                }
                //generate new state
                input.put(keyvalue.getKey(),pickWeightedRandom());
                return input;
            }
        }

        return input;
    }

}
