package father.frost.booking

import grails.converters.JSON
import org.ffbooking.Price

class PriceController {

    def index() {
        render Price.listOrderByFrom().collect{
            def type
            def daysBetween = it.to!=null ? (it.from..it.to).size() : 100;
            if ( it.to == null ) {
                type = "RIGHT_OPEN_INTERVAL"
            }else if ( daysBetween > 20 ) {
                type = 'LEFT_OPEN_INTERVAL'
            }else if ( daysBetween > 1 ) {
                type = 'SEVERAL_DAYS'
            }else if ( it.to.getTime() - it.from.getTime() > 20 * 60 * 60 * 1000L ) {
                type = "SINGLE_DAY"
            }else {
                type = "INTERVAL"
            }
            it.type = type

            it
        } as JSON
    }
}
