package com.studentapp.utils;

import java.util.Random;

/**
 * Created by Nishant on 1/18/2019.
 */
public class TestUtils {

    public static String getRandomValue(){
        Random random = new Random();
        int randomint = random.nextInt(100000);
        return  Integer.toString(randomint);

    }
}
