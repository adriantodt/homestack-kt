package net.adriantodt.homestack.main.stacks

import net.adriantodt.homestack.dsl.compose.externalNetwork
import net.adriantodt.homestack.dsl.compose.restartUnlessStopped
import net.adriantodt.homestack.dsl.compose.stack
import net.adriantodt.homestack.dsl.compose.unaryPlus
import net.adriantodt.homestack.main.HomestackConfig

fun HomestackConfig.jellyfinStack() {
    +stack("jellyfin") {
        service {
            val port = "8084"
            val portSecure = "9084"

            image = "lscr.io/linuxserver/jellyfin"
            environment(
                "PUID" to puid,
                "PGID" to pgid,
                "TZ" to timezone,
                "DOCKER_MODS" to "linuxserver/mods:jellyfin-amd",
                "JELLYFIN_PublishedServerUrl" to "$serverUrl:$port"
            )
            ports(
                port to "8096",
                portSecure to "8920",
                "7359" to "7359/udp"
            )
            volumes(
                "$stackRoot/services/jellyfin/config" to "/config",
                "$stackRoot/files/Downloads" to "/downloads"
            )
            restartUnlessStopped()
        }
        externalNetwork(network = traefikNetwork)
    }
}
