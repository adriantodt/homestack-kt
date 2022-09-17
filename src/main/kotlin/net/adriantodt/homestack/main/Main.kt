package net.adriantodt.homestack.main

import net.adriantodt.homestack.dsl.docker.DockerNetwork
import net.adriantodt.homestack.main.stacks.*

fun main() {
    val config = HomestackConfig(
        stackRoot = "./run",

        puid = "1000",
        pgid = "1000",

        timezone = "America/Sao_Paulo",
        serverUrl = "192.168.15.5",

        traefikNetwork = DockerNetwork("homestack_traefik_access_network", attachable = true),
        internalNetwork = DockerNetwork("homestack_internal_services_network", attachable = true),
    )

    config.run {
        traefikStack()
        portainerStack()
        filebrowserStack()
        qbittorrentStack()
        jellyfinStack()
    }
}

