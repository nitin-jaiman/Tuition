package com;

import java.math.BigInteger;

/**
 * Created by apple on 07/01/17.
 */
public class TestHackerEarth {

    public static void main(String args[]){


//        System.out.println( Integer.parseInt((Integer.toBinaryString(7)),2));

           manupilateBinaryString(Integer.toBinaryString(7));

    }



    public static void manupilateBinaryString(String binaryNumber){



        System.out.println(binaryNumber);

        StringBuffer stringBuffer=new StringBuffer(binaryNumber);
        System.out.println(new  StringBuffer( stringBuffer.reverse().toString().replaceFirst("0","1")).reverse().toString());









    }


}
