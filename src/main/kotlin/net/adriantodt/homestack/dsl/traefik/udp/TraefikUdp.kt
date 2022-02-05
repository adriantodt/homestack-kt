package net.adriantodt.homestack.dsl.traefik.udp

import net.adriantodt.homestack.dsl.traefik.TraefikConfiguration

open class TraefikUdp(val parent: TraefikConfiguration) {
    open fun router(name: String): TraefikUdpRouter {
        return TraefikUdpRouter(this, name)
    }

    open fun service(name: String): TraefikUdpService {
        return TraefikUdpService(this, name)
    }

}
