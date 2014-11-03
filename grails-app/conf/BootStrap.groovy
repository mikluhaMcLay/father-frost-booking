import grails.converters.JSON
import org.ffbooking.Price

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        def DATE_FORMAT = 'yyyy/MM/dd HH'
        def dateFormatter = new SimpleDateFormat( DATE_FORMAT )

        new Price(
                from: Date.parse( DATE_FORMAT, '2014/12/27 12' ),
                to: Date.parse( DATE_FORMAT, '2014/12/27 18' ),
                price: 5000
        ).save()

        new Price(
                from: Date.parse( DATE_FORMAT, '2014/12/27 18' ),
                to: Date.parse( DATE_FORMAT, '2014/12/27 22' ),
                price: 5500
        ).save()

        new Price(
                from: Date.parse( DATE_FORMAT, '2014/12/28 08' ),
                to: Date.parse( DATE_FORMAT, '2014/12/28 18' ),
                price: 6000
        ).save()

        JSON.registerObjectMarshaller( Price ) {
            def map = [ : ]
            map[ 'start_date' ] = dateFormatter.format( it.from )
            map[ 'end_date' ] = dateFormatter.format( it.to )
            map[ 'text' ] = it.price as String
            return map
        }
    }
    def destroy = {
    }
}
