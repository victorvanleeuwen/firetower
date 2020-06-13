package com.firetower.alert_service.common.utils;

public class HostProvider {

    public static Boolean live = true;

    public static String getUserService(){
        if(live){
            return "http://10.64.5.115:9000/";
        }
        else {
            return "http://localhost:9000/";
        }

    }
    public static String getAuthService(){
        if(live){
            return "http://10.64.3.15:9010/";
        }
        else {
            return "http://localhost:9010/";
        }

    }
    public static String getServerService(){
        if(live){
            return "http://10.64.1.248:9030/";
        }
        else {
            return "http://localhost:9030/";
        }

    }
    public static String getLogService(){
        if(live){
            return "http://10.64.5.39:9040/";
        }
        else {
            return "http://localhost:9040/";
        }

    }
    public static String getMetricService(){
        if(live){
            return "http://10.64.8.16:9050";
        }
        else {
            return "http://localhost:9050/";
        }
    }
    public static String getGeneratorService(){
        if(live){
            return "http://10.64.1.180:9060/";

        }
        else {
            return "http://localhost:9060/";

        }

    }
    public static String getAlertService(){
        if(live){
            return "http://10.64.5.139:9070/";

        }
        else {
            return "http://localhost:9070/";

        }

    }
    public static String getMonitoringService(){
        if(live){
            return "http://10.64.1.129:9080/";

        }
        else {
            return "http://localhost:9080/";
        }

    }
}
