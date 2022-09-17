package net.adriantodt.homestack.main.stacks

import net.adriantodt.homestack.dsl.compose.enableDockerAccess
import net.adriantodt.homestack.dsl.compose.restartUnlessStopped
import net.adriantodt.homestack.dsl.compose.stack
import net.adriantodt.homestack.dsl.compose.unaryPlus
import net.adriantodt.homestack.main.HomestackConfig

fun HomestackConfig.traefikStack() {
    +stack("traefik") {
        service {
            image = "traefik:v2.5"
            command(
                "--api.insecure=true",
                "--providers.docker",
                "--accesslog=true"
            )
            ports(
                "80" to "80",
                "443" to "443",
                "8080" to "8080/tcp"
            )
            enableDockerAccess(volumeAccess = true)
            restartUnlessStopped()
        }
    }
}
