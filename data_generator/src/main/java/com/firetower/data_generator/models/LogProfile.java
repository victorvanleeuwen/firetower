package com.firetower.data_generator.models;

import java.util.HashMap;
import java.util.Map;

public class LogProfile {


    public static Map<String,Integer> getNormalSystemLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("The system shutdown",1);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",4);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",5);
        result.put("Device connected to system",5);
        result.put("Failed to communicate with device",1);

        return result;
    }
    public static Map<String,Integer> getNormalApplcationLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Application startup",5);
        result.put("Application shutdown",5);
        result.put("Application encountered critical error",2);
        result.put("Failed to update application configuration",1);
        result.put("Successfully updated application configuration",5);
        result.put("Application warning",8);
        result.put("Service startup",15);
        result.put("Service shutdown",15);
        return result;
    }
    public static Map<String,Integer> getNormalSecurityLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Failed login attempt on system",2);
        result.put("Successful login attempt on system",10);
        result.put("Failed to create administrator user",1);
        result.put("Successfully created administrator user",2);
        result.put("Failed to create normal user",1);
        result.put("Successfully created normal user",2);
        result.put("Failed to  update user permissions",1);
        result.put("Successfully updated user permissions",4);
        result.put("Failed to update security settings",1);
        result.put("Successfully updated security settings",1);

        return result;
    }


    public static Map<String,Integer> getmalicousSystemLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("The system shutdown",4);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",6);
        result.put("Failed to make changes to the network interface",4);
        result.put("New device connected to system",20);
        result.put("Device connected to system",20);
        result.put("Failed to communicate with device",5);
        return result;
    }
    public static Map<String,Integer> getmalicousApplcationLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Application startup",10);
        result.put("Application shutdown",10);
        result.put("Application encountered critical error",30);
        result.put("Failed to update application configuration",15);
        result.put("Successfully updated application configuration",15);
        result.put("Application warning",15);
        result.put("Service startup",5);
        result.put("Service shutdown",5);
        return result;
    }
    public static Map<String,Integer> getmalicousSecurityLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Failed login attempt on system",70);
        result.put("Successful login attempt on system",10);
        result.put("Failed to create administrator user",10);
        result.put("Successfully created administrator user",5);
        result.put("Failed to create normal user",5);
        result.put("Successfully created normal user",5);
        result.put("Failed to  update user permissions",4);
        result.put("Successfully updated user permissions",9);
        result.put("Failed to update security settings",9);
        result.put("Successfully updated security settings",60);

        return result;
    }

    public static Map<String,Integer> getHeavyLoadSystemLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("The system shutdown",1);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",4);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",5);
        result.put("Device connected to system",5);
        result.put("Failed to communicate with device",4);
        return result;
    }
    public static Map<String,Integer> getHeavyLoadApplcationLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Application startup",20);
        result.put("Application shutdown",10);
        result.put("Application encountered critical error",40);
        result.put("Failed to update application configuration",4);
        result.put("Successfully updated application configuration",4);
        result.put("Application warning",60);
        result.put("Service startup",1);
        result.put("Service shutdown",25);
        return result;
    }
    public static Map<String,Integer> getHeavyLoadSecurityLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();


        result.put("Failed login attempt on system",2);
        result.put("Successful login attempt on system",11);
        result.put("Failed to create administrator user",1);
        result.put("Successfully created administrator user",2);
        result.put("Failed to create normal user",1);
        result.put("Successfully created normal user",2);
        result.put("Failed to  update user permissions",1);
        result.put("Successfully updated user permissions",4);
        result.put("Failed to update security settings",1);
        result.put("Successfully updated security settings",1);
        return result;
    }

    public static Map<String,Integer> getSoftWareissueSystemLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("The system shutdown",5);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",2);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",1);
        result.put("Device connected to system",1);
        result.put("Failed to communicate with device",1);
        return result;
    }
    public static Map<String,Integer> getSoftWareissueApplcationLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Application startup",20);
        result.put("Application shutdown",30);
        result.put("Application encountered critical error",25);
        result.put("Failed to update application configuration",10);
        result.put("Successfully updated application configuration",5);
        result.put("Application warning",60);
        result.put("Service startup",8);
        result.put("Service shutdown",10);
        return result;
    }
    public static Map<String,Integer> getSoftWareissueSecurityLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();


        result.put("Failed login attempt on system",2);
        result.put("Successful login attempt on system",12);
        result.put("Failed to create administrator user",1);
        result.put("Successfully created administrator user",2);
        result.put("Failed to create normal user",1);
        result.put("Successfully created normal user",2);
        result.put("Failed to  update user permissions",1);
        result.put("Successfully updated user permissions",4);
        result.put("Failed to update security settings",1);
        result.put("Successfully updated security settings",1);
        return result;
    }

    public static Map<String,Integer> getHardWareissueSystemLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("The system shutdown",40);
        result.put("The system turned on",20);
        result.put("Changes have been made to the network interface",10);
        result.put("Failed to make changes to the network interface",4);
        result.put("New device connected to system",30);
        result.put("Device connected to system",30);
        result.put("Failed to communicate with device",50);
        return result;
    }
    public static Map<String,Integer> getHardWareissueApplcationLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();

        result.put("Application startup",1);
        result.put("Application shutdown",1);
        result.put("Application encountered critical error",5);
        result.put("Failed to update application configuration",4);
        result.put("Successfully updated application configuration",4);
        result.put("Application warning",15);
        result.put("Service startup",10);
        result.put("Service shutdown",10);
        return result;
    }
    public static Map<String,Integer> getHardWareissueSecurityLogs(){
        HashMap<String,Integer> result = new HashMap<String, Integer>();


        result.put("Failed login attempt on system",20);
        result.put("Successful login attempt on system",12);
        result.put("Failed to create administrator user",1);
        result.put("Successfully created administrator user",2);
        result.put("Failed to create normal user",1);
        result.put("Successfully created normal user",2);
        result.put("Failed to  update user permissions",1);
        result.put("Successfully updated user permissions",4);
        result.put("Failed to update security settings",1);
        result.put("Successfully updated security settings",1);
        return result;
    }



}
