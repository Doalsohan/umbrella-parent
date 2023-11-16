package com.umbrella.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@SpringBootApplication
class BlogApplication {

    fun main(args:Array<String>) {
        runApplication<BlogApplication>(*args);
    }


    fun sum(a:Int, b:Int): Int{
        return a + b;
    }
}