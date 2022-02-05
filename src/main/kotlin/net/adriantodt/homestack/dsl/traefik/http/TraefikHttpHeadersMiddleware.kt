package net.adriantodt.homestack.dsl.traefik.http

class TraefikHttpHeadersMiddleware(val parent: TraefikHttpMiddleware) {
    fun customRequestHeaders(vararg values: Pair<String, String>) {
        parent.parent.parent.parent.label(
            *values.map { (k, v) -> "traefik.http.middlewares.${parent.name}.headers.customrequestheaders.$k" to v }
                .toTypedArray()
        )
    }

}
