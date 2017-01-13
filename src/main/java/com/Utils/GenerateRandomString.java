package com.Utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by apple on 30/12/16.
 */
public class GenerateRandomString {



    public static String getRandomString(){

        Random random = new Random();

        return new BigInteger(130, random).toString(32);

    }


}
