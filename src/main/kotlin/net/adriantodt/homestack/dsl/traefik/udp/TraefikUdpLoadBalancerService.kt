package net.adriantodt.homestack.dsl.traefik.udp

open class TraefikUdpLoadBalancerService(val parent: TraefikUdpService) {
    protected open val protocol: String = "udp"

    var serverPort: String? = null
        set(value) {
            if (value != null) {
                parent.parent.parent.parent.label(
                    "traefik.$protocol.services.${parent.name}.loadbalancer.server.port" to value
                )
            }
            field = value
        }
}
