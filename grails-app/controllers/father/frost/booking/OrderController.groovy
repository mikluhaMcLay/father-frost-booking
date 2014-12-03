package father.frost.booking

import grails.converters.JSON
import grails.rest.RestfulController
import groovy.time.TimeCategory
import org.ffbooking.Order

import java.text.SimpleDateFormat

class OrderController extends RestfulController {
    static responseFormats = [ 'json' ]

    def dateFormat = new SimpleDateFormat( 'dd.MM HH:mm' )


    OrderController() {
        super( Order )
    }

    def save() {
        def orderParams = params
        def bookDate = dateFormat.parse( params.bookDate )
        if ( bookDate.month == 0 ) {
            bookDate.year = 115;//year 2015
        } else {
            bookDate.year = 114;//year 2014
        }

        log.debug "bookDate: ${ bookDate }"
        orderParams.bookDate = bookDate

        def order = new Order( orderParams )
        log.debug "Order: ${ order }"

        def saved = order.save()
        log.info "Order saved: ${ saved }"

        render( success: true ) as JSON
    }

    def times() {
//        response.setContentType( 'text/json' )

        def intervalRequest = params.interval
        def splited = intervalRequest.split( '(-)|(—)' )
        log.debug "splited: ${ splited }"

        def hourTo = splited[ 1 ].trim()
        def hourFrom = splited[ 0 ].split( ' ' )[ 2 ].trim()

        def dateFormat = new SimpleDateFormat( 'HH:mm' )

        def dateFrom = dateFormat.parse( hourFrom )
        def dateTo = dateFormat.parse( hourTo )

        def currentDate = dateFrom

        def times = [ ]
        while ( !currentDate.after( dateTo ) ) {
            times << dateFormat.format( currentDate )
            use( TimeCategory ) {
                currentDate = currentDate + 30.minutes
            }
        }

        render new TimesResponse( times: times ) as JSON
    }

    class TimesResponse {
        static {
            grails.converters.JSON.registerObjectMarshaller( TimesResponse ) {
                // you can filter here the key-value pairs to output:
                return it.properties.findAll { k, v -> k == 'times' }
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