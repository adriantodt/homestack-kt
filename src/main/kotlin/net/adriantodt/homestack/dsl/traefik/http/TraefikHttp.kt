package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration
import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcp

class TraefikHttp(parent: TraefikConfiguration): TraefikTcp(parent) {
    override fun router(name: String): TraefikHttpRouter {
        return TraefikHttpRouter(this, name)
    }

    override fun middleware(name: String): TraefikHttpMiddleware {
        return TraefikHttpMiddleware(this, name)
    }

    override fun service(name: String): TraefikHttpService {
        return TraefikHttpService(this, name)
    }
}
