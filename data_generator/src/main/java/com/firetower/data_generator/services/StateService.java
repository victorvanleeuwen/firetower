package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Server;
import com.firetower.data_generator.models.ServerState;
import com.firetower.data_generator.models.State;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StateService {


    public  Dictionary<Server,ServerState> setup(List<Server> servers){

        Dictionary<Server,ServerState> result = new Hashtable<Server,ServerState>();


        for (Server server: servers) {


        }

        return null;
    }
    private ServerState pickrandom(){
        Random randomGenerator = new Random();
        Integer sumOfWeight = 0;

        for (State state:State.values()) {
            sumOfWeight +=state.getWeight();
        }
        int randomInteger = randomGenerator.nextInt(sumOfWeight);

        //finisch algo
        /***
         * There is a straightforward algorithm for picking an item at random, where items have individual weights:
         *
         * 1) calculate the sum of all the weights
         *
         * 2) pick a random number that is 0 or greater and is less than the sum of the weights
         *
         * 3) go through the items one at a time, subtracting their weight from your random number, until you get the item where the random number is less than that item's weight
         *
         * Pseudo-code illustrating this:
         *
         * int sum_of_weight = 0;
         * for(int i=0; i<num_choices; i++) {
         *    sum_of_weight += choice_weight[i];
         * }
         * int rnd = random(sum_of_weight);
         * for(int i=0; i<num_choices; i++) {
         *   if(rnd < choice_weight[i])
         *     return i;
         *   rnd -= choice_weight[i];
         * }
         * assert(!"should never get here");
         */

        return null;
    }

}
