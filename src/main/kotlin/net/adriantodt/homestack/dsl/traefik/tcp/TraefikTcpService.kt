package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdpService

open class TraefikTcpService(parent: TraefikTcp, name: String) : TraefikUdpService(parent, name) {
    override val protocol: String = "tcp"

    override val loadBalancer get() = TraefikTcpLoadBalancerService(this)
}
