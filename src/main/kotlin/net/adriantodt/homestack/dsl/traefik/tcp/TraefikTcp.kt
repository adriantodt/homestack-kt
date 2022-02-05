package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration
import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdp

open class TraefikTcp(parent: TraefikConfiguration) : TraefikUdp(parent) {
    override fun router(name: String): TraefikTcpRouter {
        return TraefikTcpRouter(this, name)
    }

    open fun middleware(name: String): TraefikTcpMiddleware {
        return TraefikTcpMiddleware(this, name)
    }

    override fun service(name: String): TraefikTcpService {
        return TraefikTcpService(this, name)
    }
}
