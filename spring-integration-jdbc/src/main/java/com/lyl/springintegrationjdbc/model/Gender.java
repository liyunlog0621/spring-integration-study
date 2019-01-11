package com.lyl.springintegrationjdbc.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Gender
 * Author liyunlong
 * Data 上午 10:44
 * Version 1.0
 **/
public class Gender {
    private static Map<String, Gender> map;

    private String identifier;

    private Gender(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public static Gender getGenderByIdentifier(String identifier) {
        return map.get(identifier);
    }
}
