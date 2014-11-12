import grails.converters.JSON
import org.bson.types.ObjectId
import org.ffbooking.Price

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        def DATE_FORMAT = 'yyyy/MM/dd HH'
        def dateFormatter = new SimpleDateFormat( DATE_FORMAT )

        try {
            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/27 12' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/27 18' ),
                    price: 5000
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/27 18' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/27 22' ),
                    price: 5500
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/28 08' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/28 18' ),
                    price: 6000
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/26 10' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/28 22' ),
                    price: 4000
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/25 10' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/25 22' ),
                    price: 4000
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/29 10' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/29 22' ),
                    price: 6500
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/30 10' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/30 22' ),
                    price: 6500
            ).insert()

            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 08' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 15' ),
                    price: 6500
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 15' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 17' ),
                    price: 6700
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 17' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 19' ),
                    price: 7000
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 19' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 21' ),
                    price: 8000
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 21' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 22' ),
                    price: 8500
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 22' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 23' ),
                    price: 9400
            ).insert()


            new Price(
                    from: Date.parse( DATE_FORMAT, '2014/12/31 23' ),
                    to: Date.parse( DATE_FORMAT, '2014/12/31 24' ),
                    price: 10000
            ).insert()
        } catch ( Throwable error ) {
            log.warn( "Not saved on startup cause: $error   " )
        }


        JSON.registerObjectMarshaller( Price ) {
            def map = [ : ]
            map[ 'id' ] = (( ObjectId ) it.id).toHexString()
            map[ 'start_date' ] = dateFormatter.format( it.from )
            map[ 'end_date' ] = dateFormatter.format( it.to )
            map[ 'text' ] = it.price as String
            return map
        }
    }
    def destroy = {
    }

    def color( price ) {
        switch ( price ){
            case 4000: return 0x0FBBDF
        }
    }
}
