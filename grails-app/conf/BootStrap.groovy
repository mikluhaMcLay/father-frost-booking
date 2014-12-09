import grails.converters.JSON
import org.ffbooking.Price

import java.text.SimpleDateFormat

class BootStrap {

    def dayFormat = new SimpleDateFormat('dd MMMMM', new Locale('ru', 'RU'))
    def shortDayFormat = new SimpleDateFormat('dd MMM', new Locale('ru', 'RU'))
    def hourFormat = new SimpleDateFormat( 'HH:mm' )

    def init = { servletContext ->
        def DATE_FORMAT = 'yyyy/MM/dd HH'
//        def dateFormatter = DateFormat.getDateInstance( DateFormat.MEDIUM, new Locale( 'ru', 'RU' ) )

        JSON.registerObjectMarshaller( Price ) {
            def map = [ : ]
            map[ 'interval' ] = intervalToString( it.from, it.to )
            map[ 'price' ] = it.price + ' ' + '\u20BD'
            map[ 'type' ] = it.type
            return map
        }
    }

    def intervalToString(from, to) {
        def interval
        def intervalInDays = to != null ? (from..to).size() : 0

        if ( to == null ) {
            // если to не определена, то это последний интервал
            interval = "с ${dayFormat.format( from )}"
        }else if ( intervalInDays > 15 ) {
            //если интервал больше 15 дней, то это самый ранний интервал у нас
            interval = "до ${ dayFormat.format( to ) }"
        }else if ( isSameDay( from, to ) ) {
            //тогда показываем один день
            if ( to.getTime() - from.getTime() > 20 * 60 * 60 * 1000L) {
                //если больше 20 часов, то показываем только день, без времени
                interval = dayFormat.format( from );//to & from — это один день — пофиг, какой показывать
            }else {
                interval = "${ dayFormat.format( from ) } ${ hourFormat.format( from ) } — ${ hourFormat.format( to ) }"
            }
        } else {
            //пусть если интервал меньше суток, то показываем часы (случай 31 дек — 1 янв); если больше суток, то дни
            if ( intervalInDays > 1 ) {
                interval = "${ dayFormat.format( from ) } — ${ dayFormat.format( to ) }"
            }else{
                interval = "${shortDayFormat.format( from )} ${hourFormat.format( from )} — ${shortDayFormat.format( to )} ${ hourFormat.format( to ) }"
            }
        }

        interval
    }

    def isSameDay( firstDate, secondDate ) {
        dayFormat.format( firstDate ) == dayFormat.format( secondDate )
    }
    def destroy = {
    }
}
