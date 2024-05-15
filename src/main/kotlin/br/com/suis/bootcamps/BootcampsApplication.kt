package br.com.suis.bootcamps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootcampsApplication

fun main(args: Array<String>) {
	runApplication<BootcampsApplication>(*args)
}