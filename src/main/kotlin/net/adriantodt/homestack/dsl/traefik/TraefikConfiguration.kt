package net.adriantodt.homestack.dsl.traefik

import net.adriantodt.homestack.dsl.compose.CompositionService
import net.adriantodt.homestack.dsl.traefik.http.TraefikHttp
import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcp
import net.adriantodt.homestack.dsl.traefik.udp.TraefikUdp

class TraefikConfiguration(val parent: CompositionService) {
    val http by lazy { TraefikHttp(this) }
    val tcp by lazy { TraefikTcp(this) }
    val udp by lazy { TraefikUdp(this) }

    var enabled: Boolean? = null
        set(value) {
            field = value?.also { parent.label("traefik.enable" to value.toString()) }
        }

    var dockerNetwork: String? = null
        set(value) {
            field = value?.also { parent.label("traefik.docker.network" to value) }
        }

    init {
//        this.http.router("router_name").rule
//        this.http.router("router_name").entrypoints
//        this.http.router("router_name").middlewares
//        this.http.router("router_name").service
//        this.http.router("router_name").tls
//        this.http.router("router_name").tls.certresolver
//        this.http.router("router_name").tls.domains[n].main
//        this.http.router("router_name").tls.domains[n].sans
//        this.http.router("router_name").tls.options
//        this.http.router("router_name").priority
//        this.http.service("service_name").loadbalancer.server.port
//        this.http.service("service_name").loadbalancer.server.scheme
//        this.http.service("service_name").loadbalancer.serverstransport
//        this.http.service("service_name").loadbalancer.passhostheader
//        this.http.service("service_name").loadbalancer.healthcheck.headers.<header_name>
//        this.http.service("service_name").loadbalancer.healthcheck.hostname
//        this.http.service("service_name").loadbalancer.healthcheck.interval
//        this.http.service("service_name").loadbalancer.healthcheck.path
//        this.http.service("service_name").loadbalancer.healthcheck.port
//        this.http.service("service_name").loadbalancer.healthcheck.scheme
//        this.http.service("service_name").loadbalancer.healthcheck.timeout
//        this.http.service("service_name").loadbalancer.healthcheck.followredirects
//        this.http.service("service_name").loadbalancer.sticky.cookie
//        this.http.service("service_name").loadbalancer.sticky.cookie.httponly
//        this.http.service("service_name").loadbalancer.sticky.cookie.name
//        this.http.service("service_name").loadbalancer.sticky.cookie.secure
//        this.http.service("service_name").loadbalancer.sticky.cookie.samesite
//        this.http.service("service_name").loadbalancer.responseforwarding.flushinterval
//        this.tcp.router("router_name").entrypoints
//        this.tcp.router("router_name").rule
//        this.tcp.router("router_name").service
//        this.tcp.router("router_name").tls
//        this.tcp.router("router_name").tls.certresolver
//        this.tcp.router("router_name").tls.domains[n].main
//        this.tcp.router("router_name").tls.domains[n].sans
//        this.tcp.router("router_name").tls.options
//        this.tcp.router("router_name").tls.passthrough
//        this.tcp.service("service_name").loadbalancer.server.port
//        this.tcp.service("service_name").loadbalancer.terminationdelay
//        this.tcp.service("service_name").loadbalancer.proxyprotocol.version
//        this.udp.router("router_name").entrypoints
//        this.udp.router("router_name").service = "service_name"
//        this.udp.service("service_name").loadbalancer.server.port
    }
}

