package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration

val TraefikConfiguration.tcpRouter get() = tcpRouter()

fun TraefikConfiguration.tcpRouter(
    name: String = "${this.parent.name}-router"
): TraefikTcpRouter {
    return tcp.router(name)
}

fun TraefikConfiguration.tcpRouter(
    name: String = "${this.parent.name}-router",
    block: TraefikTcpRouter.() -> Unit
): TraefikTcpRouter {
    return tcpRouter(name).apply(block)
}

val TraefikTcp.router get() = router("${this.parent.parent.name}-router")

fun TraefikTcp.router(
    name: String = "${this.parent.parent.name}-router",
    block: TraefikTcpRouter.() -> Unit
): TraefikTcpRouter {
    return router(name).apply(block)
}


val TraefikConfiguration.tcpMiddleware get() = tcpMiddleware()

fun TraefikConfiguration.tcpMiddleware(
    name: String = "${this.parent.name}-middleware"
): TraefikTcpMiddleware {
    return tcp.middleware(name)
}

fun TraefikConfiguration.tcpMiddleware(
    name: String = "${this.parent.name}-middleware",
    block: TraefikTcpMiddleware.() -> Unit
): TraefikTcpMiddleware {
    return tcpMiddleware(name).apply(block)
}

val TraefikTcp.middleware get() = middleware("${this.parent.parent.name}-middleware")

fun TraefikTcp.middleware(
    name: String = "${this.parent.parent.name}-middleware",
    block: TraefikTcpMiddleware.() -> Unit
): TraefikTcpMiddleware {
    return middleware(name).apply(block)
}


val TraefikConfiguration.tcpService get() = tcpService()

fun TraefikConfiguration.tcpService(
    name: String = "${this.parent.name}-service"
): TraefikTcpService {
    return tcp.service(name)
}

fun TraefikConfiguration.tcpService(
    name: String = "${this.parent.name}-service",
    block: TraefikTcpService.() -> Unit
): TraefikTcpService {
    return tcpService(name).apply(block)
}

val TraefikTcp.service get() = service("${this.parent.parent.name}-service")

fun TraefikTcp.service(
    name: String = "${this.parent.parent.name}-service",
    block: TraefikTcpService.() -> Unit
): TraefikTcpService {
    return service(name).apply(block)
}
