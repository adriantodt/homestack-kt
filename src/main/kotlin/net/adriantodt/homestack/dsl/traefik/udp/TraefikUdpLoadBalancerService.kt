package net.adriantodt.homestack.dsl.traefik.udp

import net.adriantodt.homestack.dsl.traefik.CompositionServiceAccess
import net.adriantodt.homestack.dsl.traefik.Named

open class TraefikUdpLoadBalancerService(
    val parent: TraefikUdpService
) : Named by parent, CompositionServiceAccess by parent {
    protected open val protocol: String = "udp"

    var serverPort: String? = null
        set(value) {
            if (value != null) {
                composeService.label(
                    "traefik.$protocol.services.$name.loadbalancer.server.port" to value
                )
            }
            field = value
        }
}
