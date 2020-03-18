package com.firetower.datagenerator.services;

import com.firetower.common.models.Company;
import com.firetower.common.models.Server;
import com.firetower.common.models.enums.OperatingSystemType;
import com.firetower.common.models.utils.RandomUtil;
import com.firetower.datagenerator.repositories.CompanyRepository;
import com.firetower.datagenerator.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GeneratorService {
    private CompanyRepository companyRepository;
    private ServerRepository serverRepository;

    private List<String> compNames;
    private List<String> serverNames;
    private  Integer compCount;
    private  Integer serverMax;

    @Autowired
    public GeneratorService(CompanyRepository companyRepository, ServerRepository serverRepository) {
        this.companyRepository = companyRepository;
        this.serverRepository = serverRepository;
    }
    public List<Company> startGeneration(List<String> compNames, List<String> serverNames, Integer compCount, Integer serverMax){
        this.compNames = compNames;
        this.serverNames = serverNames;
        this.compCount = compCount;
        this.serverMax = serverMax;
        return generateCompanies();
    }

    private List<Company> generateCompanies(){
        List<Company> companies = new ArrayList<Company>();
        Integer i = 0;
        while (i < compCount){
            String name = (String) RandomUtil.getRandomElement(this.compNames);
            Company company = new Company(name);
            company = companyRepository.save(company);
            company.setServers(generateServers(company.getId()));
            companies.add(company);
            i++;
        }
        return companies;
    }

    private List<Server> generateServers(Long companyId){
        List<Server> servers = new ArrayList<Server>();
        Random random = new Random();
        Integer amount = random.nextInt(this.serverMax);
        Integer i = 0;
        while (i < amount){
            String name = (String) RandomUtil.getRandomElement(serverNames);
            String ip = RandomUtil.generateRandomIp();
            OperatingSystemType os = RandomUtil.randomEnum(OperatingSystemType.class);
            Server server = new Server(name,ip,os,companyId);
            server = serverRepository.save(server);
            servers.add(server);
            i++;
        }
        return servers;
    }
}
