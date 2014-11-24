class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/order/times" {
            controller = "order"
            action = "times"
        }

        "/"( view: "/index" )
        "500"( view: '/error' )
    }
}
