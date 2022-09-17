package net.adriantodt.homestack.dsl.traefik.udp

import net.adriantodt.homestack.dsl.traefik.CompositionServiceAccess
import net.adriantodt.homestack.dsl.traefik.Named

open class TraefikUdpService(
    val parent: TraefikUdp,
    override val name: String
) : Named, CompositionServiceAccess by parent {
    protected open val protocol: String = "udp"

    open val loadBalancer get() = TraefikUdpLoadBalancerService(this)
}
