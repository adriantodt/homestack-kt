package net.adriantodt.homestack.main

import net.adriantodt.homestack.dsl.compose.*
import net.adriantodt.homestack.dsl.docker.DockerNetwork
import net.adriantodt.homestack.dsl.traefik.*
import net.adriantodt.homestack.dsl.traefik.http.httpRouter
import net.adriantodt.homestack.dsl.traefik.http.middleware
import net.adriantodt.homestack.dsl.traefik.http.router
import net.adriantodt.homestack.dsl.traefik.http.service
import net.adriantodt.homestack.dsl.traefik.rule.Host

fun main() {
    val default = "default"

    val stackRoot = "./run"
    val puid = "1000"
    val pgid = "1000"
    val timezone = "America/Sao_Paulo"

    val traefikNetwork = DockerNetwork("homestack_traefik_access_network", attachable = true)
    val internalNetwork = DockerNetwork("homestack_internal_services_network", attachable = true)

    +stack("portainer") {
        service {
            image = "portainer/portainer-ce"
            enableDockerAccess(volumeAccess = true)
            volumes("$stackRoot/services/portainer/data" to "/data")
            restartUnlessStopped()
            ports("8081" to "80")
        }
        externalNetwork(default, traefikNetwork)
    }

    +stack("filebrowser") {
        service {
            image = "filebrowser/filebrowser:s6"
            environment("PUID" to puid, "PGID" to pgid)
            volumes(
                "$stackRoot/services/filebrowser/config" to "/config",
                "$stackRoot/services/filebrowser/database" to "/database",
                stackRoot to "/srv",
            )
            restartUnlessStopped()
            ports("8082" to "80")

            traefikIntegration {
                enable()
                httpRouter.rule = Host("files.home.adriantodt.net")
            }
        }
        externalNetwork(default, traefikNetwork)
    }

    +stack("qbittorrent") {
        service {
            val port = "8083"
            image = "lscr.io/linuxserver/qbittorrent"
            environment(
                "PUID" to puid,
                "PGID" to pgid,
                "TZ" to timezone,
                "WEBUI_PORT" to port
            )
            ports(
                "6881" to "6881",
                "6881" to "6881/udp",
                port to port
            )
            networks("default", "internal")
            volumes(
                "$stackRoot/services/qbittorrent/config" to "/config",
                "$stackRoot/files/Downloads" to "/downloads"
            )
            restartUnlessStopped()

            traefikIntegration {
                enable()
                http {
                    router {
                        rule = Host("seed.home.adriantodt.net")
                        middlewares = "qbittorrent-middleware"
                    }
                    middleware.headers.customRequestHeaders(
                        "X-Frame-Options" to "SAMEORIGIN",
                        "Referer" to "",
                        "Origin" to ""
                    )
                    service.loadBalancer {
                        serverPort = "8080"
                        passHostHeader = false
                    }
                }
            }
        }
        externalNetwork(default, traefikNetwork)
        externalNetwork("internal", internalNetwork)
    }
}
