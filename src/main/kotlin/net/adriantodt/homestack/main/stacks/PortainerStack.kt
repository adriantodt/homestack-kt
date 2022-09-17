package net.adriantodt.homestack.main.stacks

import net.adriantodt.homestack.dsl.compose.*
import net.adriantodt.homestack.main.HomestackConfig

fun HomestackConfig.portainerStack() {
    +stack("portainer") {
        service {
            image = "portainer/portainer-ce"
            enableDockerAccess(volumeAccess = true)
            volumes("$stackRoot/services/portainer/data" to "/data")
            restartUnlessStopped()
            ports("8081" to "80")
        }
        externalNetwork(network = traefikNetwork)
    }
}
