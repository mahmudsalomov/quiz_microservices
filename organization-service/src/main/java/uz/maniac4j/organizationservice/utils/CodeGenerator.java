package uz.maniac4j.organizationservice.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public class CodeGenerator {
    /** 6 ta belgili kod generatsiya qiladigan metod **/
    public static String generate(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(30, random).toString(32).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(generate());
        System.out.println(generate());
        System.out.println(generate());
        System.out.println(generate());
    }
}
