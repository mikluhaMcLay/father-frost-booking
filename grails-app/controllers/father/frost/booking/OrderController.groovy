package father.frost.booking

import grails.converters.JSON
import grails.rest.RestfulController
import groovy.time.TimeCategory
import org.ffbooking.Callback
import org.ffbooking.Order

import java.text.SimpleDateFormat

class OrderController extends RestfulController {
    static responseFormats = [ 'json' ]

    def dateFormat = new SimpleDateFormat( 'dd MMMMM HH:mm', new Locale( 'ru', 'RU' ) )
    def shortDateFormat = new SimpleDateFormat( 'dd MMM HH:mm', new Locale( 'ru', 'RU' ) )
    def hourFormat = new SimpleDateFormat( 'HH:mm' )

    OrderController() {
        super( Order )
    }

    def save() {
        def orderParams = params

        def bookDate

        def isOrder = params.bookDate != null && !params.bookDate.empty
        if ( isOrder ) {
            try {
                bookDate = dateFormat.parse( params.bookDate )
            } catch ( Exception e ) {
                log.info "Can't parse book date ${ params.bookDate } cause: $e"
                bookDate = shortDateFormat.parse( params.bookDate )
            }
            if ( bookDate.month == 0 ) {
                bookDate.year = 115;//year 2015
            } else {
                bookDate.year = 114;//year 2014
            }
        } else {
            bookDate = null
        }

        log.debug "bookDate: ${ bookDate }"
        orderParams.bookDate = bookDate

        def callback = new Callback( orderParams )
        def callbackSaved = callback.save()
        log.debug "Going to save callback: ${ callback }"
        log.info "Callback saved: ${ callbackSaved }"

        if ( isOrder ) {
            def order = new Order( orderParams )
            log.debug "Order: ${ order }"

            def saved = order.save()
            log.info "Order saved: ${ saved }"
        }

        render( success: true ) as JSON
    }

    def times() {
        def ( dateFrom, dateTo ) = getFromAndTo( params )

        def currentDate = dateFrom

        def times = [ ]
        while ( !currentDate.after( dateTo ) ) {
            times << hourFormat.format( currentDate )
            use( TimeCategory ) {
                currentDate = currentDate + 30.minutes
            }
        }

        render new TimesResponse( times: times ) as JSON
    }

    def callback() {
        def callback = new Callback( params )
        log.debug "Going to saved callback: $callback"

        def saved = callback.save()
        log.info( "Callback saved: $saved" )

        render( success: true ) as JSON
    }

    def getFromAndTo( params ) {
        def hourTo, hourFrom
        def dateFormat = new SimpleDateFormat( 'HH:mm' )
        def isToOnNextDay = false//на случай, когда дата "до" принадлежит следующим суткам (например, 1 января)
        if ( params.type == 'INTERVAL' ) {
            def intervalRequest = params.interval
            def splited = intervalRequest.split( '(-)|(—)' )
            log.debug "splited: ${ splited }"

            hourTo = splited[ 1 ].trim()
            def splitedToDate = hourTo.split( ' ' )
            if ( splitedToDate.size() > 1 ) {
                hourTo = splitedToDate[ 2 ].trim()
                isToOnNextDay = true
            }
            hourFrom = splited[ 0 ].split( ' ' )[ 2 ].trim()
        } else {
            hourFrom = '08:00'
            hourTo = '23:00'
        }
        def dateFrom = dateFormat.parse( hourFrom )
        def dateTo = dateFormat.parse( hourTo )
        if ( isToOnNextDay ) {
            use(TimeCategory){
                dateTo = dateTo + 1.day
            }
        }
        return [ dateFrom, dateTo ]
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