package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by apple on 24/12/16.
 */

@SpringBootApplication
public class CourseAPiApp {

    public static void main(String args[]){



        SpringApplication.run(CourseAPiApp.class,args);

    }

}
