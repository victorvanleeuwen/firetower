package com.firetower.data_generator.services;

import java.util.HashMap;
import java.util.Map;

public class LogProfile {


    public static Map<String,int> getNormalSystemLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

        result.put("The system shutdown",1);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",4);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",5);
        result.put("Device connected to system",5);
        result.put("Failed to communicate with device",1);

        return result;
    }
    public static Map<String,int> getNormalApplcationLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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
    public static Map<String,int> getNormalSecurityLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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


    public static Map<String,int> getmalicousSystemLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

        result.put("The system shutdown",4);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",6);
        result.put("Failed to make changes to the network interface",4);
        result.put("New device connected to system",20);
        result.put("Device connected to system",20);
        result.put("Failed to communicate with device",5);
        return result;
    }
    public static Map<String,int> getmalicousApplcationLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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
    public static Map<String,int> getmalicousSecurityLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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

    public static Map<String,int> getHeavyLoadSystemLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

        result.put("The system shutdown",1);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",4);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",5);
        result.put("Device connected to system",5);
        result.put("Failed to communicate with device",4);
        return result;
    }
    public static Map<String,int> getHeavyLoadApplcationLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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
    public static Map<String,int> getHeavyLoadSecurityLogs(){
        HashMap<String,int> result = new HashMap<String, int>();


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

    public static Map<String,int> getSoftWareissueSystemLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

        result.put("The system shutdown",5);
        result.put("The system turned on",1);
        result.put("Changes have been made to the network interface",2);
        result.put("Failed to make changes to the network interface",1);
        result.put("New device connected to system",1);
        result.put("Device connected to system",1);
        result.put("Failed to communicate with device",1);
        return result;
    }
    public static Map<String,int> getSoftWareissueApplcationLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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
    public static Map<String,int> getSoftWareissueSecurityLogs(){
        HashMap<String,int> result = new HashMap<String, int>();


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

    public static Map<String,int> getHardWareissueSystemLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

        result.put("The system shutdown",40);
        result.put("The system turned on",20);
        result.put("Changes have been made to the network interface",10);
        result.put("Failed to make changes to the network interface",4);
        result.put("New device connected to system",30);
        result.put("Device connected to system",30);
        result.put("Failed to communicate with device",50);
        return result;
    }
    public static Map<String,int> getHardWareissueApplcationLogs(){
        HashMap<String,int> result = new HashMap<String, int>();

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
    public static Map<String,int> getHardWareissueSecurityLogs(){
        HashMap<String,int> result = new HashMap<String, int>();


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
