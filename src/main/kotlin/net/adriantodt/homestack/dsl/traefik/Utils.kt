package net.adriantodt.homestack.dsl.traefik

import net.adriantodt.homestack.dsl.compose.CompositionService
import net.adriantodt.homestack.dsl.traefik.http.*

fun CompositionService.traefikIntegration(block: TraefikConfiguration.() -> Unit): TraefikConfiguration {
    return TraefikConfiguration(this).apply(block)
}

fun TraefikConfiguration.enable() {
    enabled = true
}

fun TraefikConfiguration.http(
    block: TraefikHttp.() -> Unit
): TraefikHttp {
    return http.apply(block)
}
