package net.adriantodt.homestack.main.stacks

import net.adriantodt.homestack.dsl.compose.externalNetwork
import net.adriantodt.homestack.dsl.compose.restartUnlessStopped
import net.adriantodt.homestack.dsl.compose.stack
import net.adriantodt.homestack.dsl.compose.unaryPlus
import net.adriantodt.homestack.dsl.traefik.enable
import net.adriantodt.homestack.dsl.traefik.http.httpRouter
import net.adriantodt.homestack.dsl.traefik.rule.Host
import net.adriantodt.homestack.dsl.traefik.traefikIntegration
import net.adriantodt.homestack.main.HomestackConfig

fun HomestackConfig.filebrowserStack() {
    +stack("filebrowser") {
        service {
            image = "filebrowser/filebrowser:s6"
            environment("PUID" to puid, "PGID" to pgid)
            volumes(
                "$stackRoot/services/filebrowser/config" to "/config",
                "$stackRoot/services/filebrowser/database" to "/database",
                stackRoot to "/srv",
            )
            restartUnlessStopped()
            ports("8082" to "80")

            traefikIntegration {
                enable()
                httpRouter.rule = Host("files.home.adriantodt.net")
            }
        }
        externalNetwork(network = traefikNetwork)
    }
}
