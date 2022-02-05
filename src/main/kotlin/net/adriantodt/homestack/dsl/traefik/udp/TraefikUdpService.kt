package net.adriantodt.homestack.dsl.traefik.udp

open class TraefikUdpService(val parent: TraefikUdp, val name: String) {
    protected open val protocol: String = "udp"

    open val loadBalancer get() = TraefikUdpLoadBalancerService(this)
}
