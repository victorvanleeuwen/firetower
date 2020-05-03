package com.firetower.data_generator.services;


import com.firetower.data_generator.common.enums.MetricType;
import com.firetower.data_generator.common.models.*;
import com.firetower.data_generator.models.ServerState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


import java.util.ArrayList;
import java.util.List;


@Service
public class GeneratorService {

    @Autowired
    private RestTemplate restTemplate;



    public  List<Server> generateServers(Long userId, int amount) throws IOException {

        try {

            ResponseEntity<Server[]> response = restTemplate.getForEntity("http://serve-service/genernate?id="+userId+"&amount="+amount,Server[].class);
            Server[] servers = response.getBody();
            ArrayList<Server> result = new ArrayList<Server>(Arrays.asList(servers));
            return result;

        }
        catch (Exception e){

            throw e;
        }
    }

    public  List<User> generateUser(int amount) throws IOException {


        try {

            ResponseEntity<User[]> response = restTemplate.getForEntity("http://user-service/generate?amount="+amount,User[].class);
            User[] users = response.getBody();
            ArrayList<User> result = new ArrayList<User>(Arrays.asList(users));
            return result;
        }
        catch (Exception e){

            throw e;
        }
    }

    private int pickWeightedNumber(Map<int,int> input){
        Random randomGenerator = new Random();
        Integer sumOfWeight = 0;

        for (Map.Entry<int,int> pointer: input.entrySet())
        {
            sumOfWeight += pointer.getValue();
        }

        int randomInteger = randomGenerator.nextInt(sumOfWeight);

        for (Map.Entry<int,int> pointer:input.entrySet()) {
            if(randomInteger < pointer.getValue()){
                return pointer.getKey();
            }
            else{
                randomInteger -= pointer.getValue();
            }
        }
        throw new IndexOutOfBoundsException("Code should never get here");


    }

    private String pickWeightedString(Map<String,int> input){
        Random randomGenerator = new Random();
        Integer sumOfWeight = 0;

        for (Map.Entry<String,int> pointer: input.entrySet())
        {
            sumOfWeight += pointer.getValue();
        }

        int randomInteger = randomGenerator.nextInt(sumOfWeight);

        for (Map.Entry<String,int> pointer:input.entrySet()) {
            if(randomInteger < pointer.getValue()){
                return pointer.getKey();
            }
            else{
                randomInteger -= pointer.getValue();
            }
        }
        throw new IndexOutOfBoundsException("Code should never get here");


    }



    public List<Log> generateLogs(Map<Server,ServerState> input)
    {
        List<Log> output = new ArrayList<Log>();
        Date date = new Date();

        for (Map.Entry<Server,ServerState> pointer:input.entrySet()) {

            switch (pointer.getValue().getState()){

                case off:
                    // The system is off, and will not send data.



                    break;

                case normal:
                    //The system is behaving like normal.

                    Random randomNormal = new Random();
                    int NormalAmountSystem = randomNormal.nextInt(1);
                    int NormalAmountApplication= randomNormal.nextInt(2);
                    int NormalAmountSecurity = randomNormal.nextInt(1);

                    int normalSystemindex = 0;
                    int normalApplicationindex = 0;
                    int normalSecurityindex = 0;

                    while( normalSystemindex < NormalAmountSystem){
                        Log normallog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getNormalSystemLogs()));
                        output.add(normallog);
                        normalSystemindex ++;
                    }

                    while( normalApplicationindex < NormalAmountApplication){
                        Log applicationLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getNormalApplcationLogs()));
                        output.add(applicationLog);
                        normalApplicationindex ++;
                    }

                    while( normalSecurityindex < NormalAmountSecurity){
                        Log SecuirtyLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getNormalSecurityLogs()));
                        output.add(SecuirtyLog);
                        normalSecurityindex ++;
                    }

                    break;

                case malicous:
                    // The system is compromised.
                    // With metrics are very inconsistent.

                    Random randommalicous = new Random();
                    int malicousAmountSystem = randommalicous.nextInt(1);
                    int malicousAmountApplication= randommalicous.nextInt(2);
                    int malicousAmountSecurity = randommalicous.nextInt(1);


                    int malicousSystemindex = 0;
                    int malicousApplicationindex = 0;
                    int malicousSecurityindex = 0;

                    while( malicousSystemindex < malicousAmountSystem){
                        Log normallog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getmalicousSystemLogs()));
                        output.add(normallog);
                        malicousSystemindex ++;
                    }

                    while( malicousApplicationindex < malicousAmountApplication){
                        Log applicationLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getmalicousApplcationLogs()));
                        output.add(applicationLog);
                        malicousApplicationindex ++;
                    }

                    while( malicousSecurityindex < malicousAmountSecurity){
                        Log SecuirtyLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getmalicousSecurityLogs()));
                        output.add(SecuirtyLog);
                        malicousSecurityindex ++;
                    }


                    break;

                case heavyLoad:
                    // The system is under heavy load.

                    Random randomheavyLoad = new Random();
                    int heavyLoadAmountSystem = randomheavyLoad.nextInt(1);
                    int heavyLoadAmountApplication= randomheavyLoad.nextInt(2);
                    int heavyLoadAmountSecurity = randomheavyLoad.nextInt(1);

                    int heavyLoadSystemindex = 0;
                    int heavyLoadApplicationindex = 0;
                    int heavyLoadSecurityindex = 0;

                    while( heavyLoadSystemindex < heavyLoadAmountSystem){
                        Log normallog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHeavyLoadSystemLogs()));
                        output.add(normallog);
                        heavyLoadSystemindex ++;
                    }

                    while( heavyLoadApplicationindex < heavyLoadAmountApplication){
                        Log applicationLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHeavyLoadApplcationLogs()));
                        output.add(applicationLog);
                        heavyLoadApplicationindex ++;
                    }

                    while( heavyLoadSecurityindex < heavyLoadAmountSecurity){
                        Log SecuirtyLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHeavyLoadSecurityLogs()));
                        output.add(SecuirtyLog);
                        heavyLoadSecurityindex ++;
                    }


                    break;

                case hardwareissue:
                    // The system has a hardware issue.

                    Random randomhardwareissue = new Random();
                    int hardwareissueAmountSystem = randomhardwareissue.nextInt(1);
                    int hardwareissueAmountApplication= randomhardwareissue.nextInt(2);
                    int hardwareissueAmountSecurity = randomhardwareissue.nextInt(1);

                    int hardwareissueSystemindex = 0;
                    int hardwareissueApplicationindex = 0;
                    int hardwareissueSecurityindex = 0;

                    while( hardwareissueSystemindex < hardwareissueAmountSystem){
                        Log normallog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHardWareissueSystemLogs()));
                        output.add(normallog);
                        hardwareissueSystemindex ++;
                    }

                    while( hardwareissueApplicationindex < hardwareissueAmountApplication){
                        Log applicationLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHardWareissueApplcationLogs()));
                        output.add(applicationLog);
                        hardwareissueApplicationindex ++;
                    }

                    while( hardwareissueSecurityindex < hardwareissueAmountSecurity){
                        Log SecuirtyLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getHardWareissueSecurityLogs()));
                        output.add(SecuirtyLog);
                        hardwareissueSecurityindex ++;
                    }

                    break;

                case softwareissue:
                    //The system has software issues.

                    Random randomsoftwareissue = new Random();
                    int softwareissueAmountSystem = randomsoftwareissue.nextInt(1);
                    int softwareissueAmountApplication= randomsoftwareissue.nextInt(2);
                    int softwareissueAmountSecurity = randomsoftwareissue.nextInt(1);

                    int softwareissueSystemindex = 0;
                    int softwareissueApplicationindex = 0;
                    int softwareissueSecurityindex = 0;

                    while( softwareissueSystemindex < softwareissueAmountSystem){
                        Log normallog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getSoftWareissueSystemLogs()));
                        output.add(normallog);
                        softwareissueSystemindex ++;
                    }

                    while( softwareissueApplicationindex < softwareissueAmountApplication){
                        Log applicationLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getSoftWareissueApplcationLogs()));
                        output.add(applicationLog);
                        softwareissueApplicationindex ++;
                    }

                    while( softwareissueSecurityindex < softwareissueAmountSecurity){
                        Log SecuirtyLog = new Log(date,pointer.getKey().getOperatingSystemType(),pointer.getKey().getId(),pickWeightedString(LogProfile.getSoftWareissueSecurityLogs()));
                        output.add(SecuirtyLog);
                        softwareissueSecurityindex ++;
                    }


                    break;

            }

        }

    }


    public List<MetricSet> generateMetricSet(Map<Server,ServerState> input){

        List<MetricSet> output = new ArrayList<MetricSet>();
        Date date = new Date();

        for (Map.Entry<Server,ServerState> pointer: input.entrySet()) {


            switch (pointer.getValue().getState()){

                case off:
                    // The system is off, and will not send data.



                    Metric  cpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,0,pointer.getKey().getId());
                    Metric  ramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,0,pointer.getKey().getId());
                    Metric  networkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,0,pointer.getKey().getId());
                    Metric  networkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,0,pointer.getKey().getId());
                    Metric  hardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,0,pointer.getKey().getId());

                    MetricSet metricSet = new MetricSet(cpuMetric,ramMetric,networkUpMetric,networkDownMetric,hardDriveUsageMetric);

                    output.add(metricSet);
                    break;

                case normal:
                    //The system is behaving like normal.

                    // cpu between 20-60 %
                    // ram between 40-70 %
                    // networkup between 50-500 mb
                    // networkdown between 50-200 mb
                    //harddriveusage between 20-60 %


                    Metric  normacpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,pickWeightedNumber(MetricProfile.getNormalCpuProfile()),pointer.getKey().getId());
                    Metric  normaramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,pickWeightedNumber(MetricProfile.getNormalRamProfile()),pointer.getKey().getId());
                    Metric  normanetworkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,pickWeightedNumber(MetricProfile.getNormalnetworkUpMetricProfile()),pointer.getKey().getId());
                    Metric  normanetworkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,pickWeightedNumber(MetricProfile.getNormalnetworDownMetricProfile()),pointer.getKey().getId());
                    Metric  normahardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,pickWeightedNumber(MetricProfile.getNormalhardDriveUsageMetricProfile()),pointer.getKey().getId());

                    MetricSet normametricSet = new MetricSet(normacpuMetric,normaramMetric,normanetworkUpMetric,normanetworkDownMetric,normahardDriveUsageMetric);

                    output.add(normametricSet);


                    break;

                case malicous:
                    // The system is compromised.
                    // With metrics are very inconsistent.

                    // cpu between 10-100 %
                    // ram between 20-100 %
                    // networkup between 50-50000 mb
                    // networkdown between 50-2000 mb
                    //harddriveusage between 20-60 %


                    Metric  malicouscpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,pickWeightedNumber(MetricProfile.getmalicousCpuProfile()),pointer.getKey().getId());
                    Metric  malicousramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,pickWeightedNumber(MetricProfile.getmalicousRamProfile()),pointer.getKey().getId());
                    Metric  malicousnetworkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,pickWeightedNumber(MetricProfile.getmalicousnetworkUpMetricProfile()),pointer.getKey().getId());
                    Metric  malicousnetworkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,pickWeightedNumber(MetricProfile.getmalicousnetworDownMetricProfile()),pointer.getKey().getId());
                    Metric  malicoushardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,pickWeightedNumber(MetricProfile.getmalicoushardDriveUsageMetricProfile()),pointer.getKey().getId());

                    MetricSet malicousmetricSet = new MetricSet(malicouscpuMetric,malicousramMetric,malicousnetworkUpMetric,malicousnetworkDownMetric,malicoushardDriveUsageMetric);

                    output.add(malicousmetricSet);

                    break;

                case heavyLoad:
                    // The system is under heavy load.
                    // With high metrics.

                    // cpu between 70-100 %
                    // ram between 80-100 %
                    // networkup between 50-500 mb
                    // networkdown between 50-200 mb
                    //harddriveusage between 20-60 %


                    Metric  heavyLoadcpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,pickWeightedNumber(MetricProfile.getHeavyLoadCpuProfile()),pointer.getKey().getId());
                    Metric  heavyLoadramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,pickWeightedNumber(MetricProfile.getHeavyLoadRamProfile()),pointer.getKey().getId());
                    Metric  heavyLoadnetworkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,pickWeightedNumber(MetricProfile.getHeavyLoadnetworkUpMetricProfile()),pointer.getKey().getId());
                    Metric  heavyLoadnetworkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,pickWeightedNumber(MetricProfile.getHeavyLoadnetworDownMetricProfile()),pointer.getKey().getId());
                    Metric  heavyLoadhardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,pickWeightedNumber(MetricProfile.getHeavyLoadhardDriveUsageMetricProfile()),pointer.getKey().getId());

                    MetricSet heavyLoadmetricSet = new MetricSet(heavyLoadcpuMetric,heavyLoadramMetric,heavyLoadnetworkUpMetric,heavyLoadnetworkDownMetric,heavyLoadhardDriveUsageMetric);

                    output.add(heavyLoadmetricSet);


                    break;

                case hardwareissue:
                    // The system has a hardware issue.
                    // The metrics are unpredictable.

                    // cpu between 5-90 %
                    // ram between 10-100 %
                    // networkup between 50-500 mb
                    // networkdown between 50-200 mb
                    //harddriveusage between 50-90 %


                    Metric  hardwareissuecpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,pickWeightedNumber(MetricProfile.getHardWareissueCpuProfile()),pointer.getKey().getId());
                    Metric  hardwareissueramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,pickWeightedNumber(MetricProfile.getHardWareissueRamProfile()),pointer.getKey().getId());
                    Metric  hardwareissuenetworkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,pickWeightedNumber(MetricProfile.getHardWareissueNetworkUpMetricProfile()),pointer.getKey().getId());
                    Metric  hardwareissuenetworkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,pickWeightedNumber(MetricProfile.getHardWareissueNetworDownMetricProfile()),pointer.getKey().getId());
                    Metric  hardwareissuehardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,pickWeightedNumber(MetricProfile.getHardWareissueHardDriveUsageMetricProfile()),pointer.getKey().getId());

                    MetricSet hardwareissuemetricSet = new MetricSet(hardwareissuecpuMetric,hardwareissueramMetric,hardwareissuenetworkUpMetric,hardwareissuenetworkDownMetric,hardwareissuehardDriveUsageMetric);

                    output.add(hardwareissuemetricSet);


                    break;

                case softwareissue:
                    //The system has software issues.
                    //The metrics are unpredictable.

                    // cpu between 20-100 %
                    // ram between 15-100 %
                    // networkup between 50-500 mb
                    // networkdown between 50-200 mb
                    //harddriveusage between 20-100 %


                    Metric  softwareissuecpuMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.CPU,pickWeightedNumber(MetricProfile.getSoftWareissueCpuProfile()),pointer.getKey().getId());
                    Metric  softwareissueramMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.RAM,pickWeightedNumber(MetricProfile.getSoftWareissueRamProfile()),pointer.getKey().getId());
                    Metric  softwareissuenetworkUpMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_UP,pickWeightedNumber(MetricProfile.getSoftWareissueNetworkUpMetricProfile()),pointer.getKey().getId());
                    Metric  softwareissuenetworkDownMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.NETWORK_DOWN,pickWeightedNumber(MetricProfile.getSoftWareissueNetworDownMetricProfile()),pointer.getKey().getId());
                    Metric  softwareissuehardDriveUsageMetric = new Metric(date,pointer.getKey().getOperatingSystemType(),MetricType.HARDDRIVE_USAGE,pickWeightedNumber(MetricProfile.getSoftWareissueHardDriveUsageMetricProfile()),pointer.getKey().getId());

                    MetricSet softwareissuemetricSet = new MetricSet(softwareissuecpuMetric,softwareissueramMetric,softwareissuenetworkUpMetric,softwareissuenetworkDownMetric,softwareissuehardDriveUsageMetric);

                    output.add(softwareissuemetricSet);


                    break;

            }
        }
        return output;
    }

}
