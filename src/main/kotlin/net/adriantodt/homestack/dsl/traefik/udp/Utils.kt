package net.adriantodt.homestack.dsl.traefik.udp

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration

val TraefikConfiguration.udpRouter get() = udpRouter()

fun TraefikConfiguration.udpRouter(
    name: String = "${this.composeService.name}-router"
): TraefikUdpRouter {
    return udp.router(name)
}

fun TraefikConfiguration.udpRouter(
    name: String = "${this.composeService.name}-router",
    block: TraefikUdpRouter.() -> Unit
): TraefikUdpRouter {
    return udpRouter(name).apply(block)
}

val TraefikUdp.router get() = router("${this.parent.composeService.name}-router")

fun TraefikUdp.router(
    name: String = "${this.parent.composeService.name}-router",
    block: TraefikUdpRouter.() -> Unit
): TraefikUdpRouter {
    return router(name).apply(block)
}



val TraefikConfiguration.udpService get() = udpService()

fun TraefikConfiguration.udpService(
    name: String = "${this.composeService.name}-service"
): TraefikUdpService {
    return udp.service(name)
}

fun TraefikConfiguration.udpService(
    name: String = "${this.composeService.name}-service",
    block: TraefikUdpService.() -> Unit
): TraefikUdpService {
    return udpService(name).apply(block)
}

val TraefikUdp.service get() = service("${this.parent.composeService.name}-service")

fun TraefikUdp.service(
    name: String = "${this.parent.composeService.name}-service",
    block: TraefikUdpService.() -> Unit
): TraefikUdpService {
    return service(name).apply(block)
}
