package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration

val TraefikConfiguration.httpRouter get() = httpRouter()

fun TraefikConfiguration.httpRouter(
    name: String = "${this.parent.name}-router"
): TraefikHttpRouter {
    return http.router(name)
}

fun TraefikConfiguration.httpRouter(
    name: String = "${this.parent.name}-router",
    block: TraefikHttpRouter.() -> Unit
): TraefikHttpRouter {
    return httpRouter(name).apply(block)
}

val TraefikHttp.router get() = router("${this.parent.parent.name}-router")

fun TraefikHttp.router(
    name: String = "${this.parent.parent.name}-router",
    block: TraefikHttpRouter.() -> Unit
): TraefikHttpRouter {
    return router(name).apply(block)
}


val TraefikConfiguration.httpMiddleware get() = httpMiddleware()

fun TraefikConfiguration.httpMiddleware(
    name: String = "${this.parent.name}-middleware"
): TraefikHttpMiddleware {
    return http.middleware(name)
}

fun TraefikConfiguration.httpMiddleware(
    name: String = "${this.parent.name}-middleware",
    block: TraefikHttpMiddleware.() -> Unit
): TraefikHttpMiddleware {
    return httpMiddleware(name).apply(block)
}

val TraefikHttp.middleware get() = middleware("${this.parent.parent.name}-middleware")

fun TraefikHttp.middleware(
    name: String = "${this.parent.parent.name}-middleware",
    block: TraefikHttpMiddleware.() -> Unit
): TraefikHttpMiddleware {
    return middleware(name).apply(block)
}


val TraefikConfiguration.httpService get() = httpService()

fun TraefikConfiguration.httpService(
    name: String = "${this.parent.name}-service"
): TraefikHttpService {
    return http.service(name)
}

fun TraefikConfiguration.httpService(
    name: String = "${this.parent.name}-service",
    block: TraefikHttpService.() -> Unit
): TraefikHttpService {
    return httpService(name).apply(block)
}

val TraefikHttp.service get() = service("${this.parent.parent.name}-service")

fun TraefikHttp.service(
    name: String = "${this.parent.parent.name}-service",
    block: TraefikHttpService.() -> Unit
): TraefikHttpService {
    return service(name).apply(block)
}
