package father.frost.booking

import grails.converters.JSON
import grails.rest.RestfulController
import org.ffbooking.Order

class OrderController extends RestfulController {
    static responseFormats = [ 'json' ]

    OrderController() {
        super( Order )
    }

    def index() {
        render Order.list( sort: 'from', order: 'asc' ) as JSON
    }

    def show(){
        def interval = params.interval
        respond ('interval': interval)
    }

    def times() {
        render ("times": ["08:00", "10:30", "12:00", "17:30"]) as JSON
    }
}