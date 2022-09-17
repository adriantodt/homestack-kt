package net.adriantodt.homestack.dsl.traefik.udp

import net.adriantodt.homestack.dsl.traefik.CompositionServiceAccess
import net.adriantodt.homestack.dsl.traefik.Named

open class TraefikUdpRouter(
    val parent: TraefikUdp,
    override val name: String
) : Named, CompositionServiceAccess by parent {
    protected open val protocol: String = "udp"

    var service: String? = null
        set(value) {
            if (value != null) {
                composeService.label("traefik.$protocol.routers.$name.service" to value)
            }
            field = value
        }
}
