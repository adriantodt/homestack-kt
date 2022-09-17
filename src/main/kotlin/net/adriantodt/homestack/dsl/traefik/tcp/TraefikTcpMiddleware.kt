package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.CompositionServiceAccess
import net.adriantodt.homestack.dsl.traefik.Named
import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdp

open class TraefikTcpMiddleware(
    val parent: TraefikUdp,
    override val name: String
) : Named,  CompositionServiceAccess by parent {
    open val protocol: String = "tcp"
}
