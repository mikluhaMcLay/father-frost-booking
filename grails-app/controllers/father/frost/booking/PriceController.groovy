package father.frost.booking

import grails.converters.JSON
import org.ffbooking.Price

class PriceController {

    def index() {
        render Price.listOrderByFrom() as JSON
    }
}
