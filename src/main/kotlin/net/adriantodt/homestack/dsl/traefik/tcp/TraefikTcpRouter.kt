package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdpRouter

open class TraefikTcpRouter(parent: TraefikTcp, name: String): TraefikUdpRouter(parent, name) {
    override val protocol: String = "tcp"

    var middlewares: String? = null
        set(value) {
            if (value != null) {
                parent.parent.parent.label("traefik.$protocol.routers.$name.middlewares" to value)
            }
            field = value
        }
}
