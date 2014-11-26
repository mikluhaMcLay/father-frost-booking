package father.frost.booking

import grails.converters.JSON
import grails.rest.RestfulController
import groovy.time.TimeCategory
import org.ffbooking.Order

import java.text.SimpleDateFormat

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
//        response.setContentType( 'text/json' )

        def intervalRequest = params.interval
        def splited = intervalRequest.split( '(-)|(—)' )
        log.debug "splited: ${ splited }"

        def hourTo = splited[ 1 ].trim()
        def hourFrom = splited[ 0 ].split( ' ' )[ 1 ].trim()

        def dateInputPattern = 'HH'
        def dateFormat = new SimpleDateFormat( 'HH:mm' )

        def dateFrom = Date.parse( dateInputPattern, hourFrom )
        def dateTo = Date.parse( dateInputPattern, hourTo )

        def currentDate = dateFrom

        def times = [ ]
        while ( !currentDate.after( dateTo ) ) {
            times << dateFormat.format( currentDate )
            use( TimeCategory ) {
                currentDate = currentDate + 30.minutes
            }
        }

        render  new TimesResponse( times: times ) as JSON
    }

    class TimesResponse{
        static {
            grails.converters.JSON.registerObjectMarshaller(TimesResponse) {
                // you can filter here the key-value pairs to output:
                return it.properties.findAll {k,v -> k == 'times'}
            }

        }
        List<String> times

        List<String> getTimes() {
            return times
        }

        void setTimes( List<String> times ) {
            this.times = times
        }
    }
}