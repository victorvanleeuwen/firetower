package com.firetower.common.utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static String generateRandomIp(){
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }

    public static Object getRandomElement(List<?> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
