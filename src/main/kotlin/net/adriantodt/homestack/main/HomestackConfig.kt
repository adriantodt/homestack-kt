package net.adriantodt.homestack.main

import net.adriantodt.homestack.dsl.docker.DockerNetwork

data class HomestackConfig(
    val stackRoot: String,
    val puid: String,
    val pgid: String,
    val timezone: String,
    val serverUrl: String,
    val traefikNetwork: DockerNetwork,
    val internalNetwork: DockerNetwork,
)
