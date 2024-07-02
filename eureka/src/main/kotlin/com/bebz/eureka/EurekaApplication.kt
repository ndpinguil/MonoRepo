package com.bebz.eureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer   //Añadido por mi
@SpringBootApplication
class EurekaApplication

fun main(args: Array<String>) {
	runApplication<EurekaApplication>(*args)
}