package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcpService

open class TraefikHttpService(parent: TraefikHttp, name: String) : TraefikTcpService(parent, name) {
    override val protocol: String = "http"

    override val loadBalancer get() = TraefikHttpLoadBalancerService(this)

    fun loadBalancer(block: TraefikHttpLoadBalancerService.() -> Unit) {
        loadBalancer.apply(block)
    }
}
