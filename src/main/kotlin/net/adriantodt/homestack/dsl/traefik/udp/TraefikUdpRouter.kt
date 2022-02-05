package net.adriantodt.homestack.dsl.traefik.udp

open class TraefikUdpRouter(val parent: TraefikUdp, val name: String) {
    protected open val protocol: String = "udp"

    var service: String? = null
        set(value) {
            if (value != null) {
                parent.parent.parent.label("traefik.$protocol.routers.$name.service" to value)
            }
            field = value
        }
}
