package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdp

open class TraefikTcpMiddleware(val parent: TraefikUdp, val name: String) {
    open val protocol: String = "tcp"

}
