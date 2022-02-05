package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcpLoadBalancerService

open class TraefikHttpLoadBalancerService(parent: TraefikHttpService) : TraefikTcpLoadBalancerService(parent) {
    override val protocol: String = "http"

    var passHostHeader: Boolean? = null
        set(value) {
            if (value != null) {
                parent.parent.parent.parent.label(
                    "traefik.$protocol.services.${parent.name}.loadbalancer.passhostheader" to value.toString()
                )
            }
            field = value
        }
}
