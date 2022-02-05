package net.adriantodt.homestack.dsl.compose

import net.adriantodt.homestack.dsl.docker.DockerNetwork
import java.io.File

@ComposeDsl
fun stack(name: String, block: CompositionStack.() -> Unit): CompositionStack {
    return CompositionStack(name).apply(block)
}

@ComposeDsl
fun CompositionStack.externalNetwork(name: String, block: CompositionNetwork.() -> Unit): CompositionNetwork {
    return network(name) {
        external = true
        block()
    }
}

@ComposeDsl
fun CompositionStack.externalNetwork(name: String, network: DockerNetwork): CompositionNetwork {
    return network(name) {
        external = true
        dockerName = network.name
    }
}

fun CompositionService.restartUnlessStopped() {
    restart = RestartBehavior.UNLESS_STOPPED
}

fun CompositionService.enableDockerAccess(volumeAccess: Boolean) {
    if (volumeAccess) {
        volumes(
            "/var/run/docker.sock" to "/var/run/docker.sock",
            "/var/lib/docker/volumes" to "/var/lib/docker/volumes",
        )
    } else {
        volumes(
            "/var/run/docker.sock" to "/var/run/docker.sock"
        )
    }
}

operator fun CompositionStack.unaryPlus() {
    File("stack_$name.yml").writeText(toString())
}
