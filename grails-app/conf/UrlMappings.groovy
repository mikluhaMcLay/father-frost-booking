class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/check-day"(controller: "order"){
            action:[POST:'checkDay']
        }

        "/"( view: "/index" )
        "500"( view: '/error' )
    }
}
