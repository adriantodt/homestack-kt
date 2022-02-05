package net.adriantodt.homestack.dsl.traefik.tcp

import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdpLoadBalancerService

open class TraefikTcpLoadBalancerService(parent: TraefikTcpService) : TraefikUdpLoadBalancerService(parent) {
    override val protocol: String = "tcp"
}
