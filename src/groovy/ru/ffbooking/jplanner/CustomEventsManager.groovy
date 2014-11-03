package ru.ffbooking.jplanner

import com.dhtmlx.planner.DHXEventsManager
import groovy.util.logging.Log4j
import org.ffbooking.Price

import javax.servlet.http.HttpServletRequest

@Log4j
class CustomEventsManager  extends DHXEventsManager{
    static {
        log.info 'CustomEventsManager loaded'
    }
    CustomEventsManager( HttpServletRequest request ) {
        super( request )
    }

    @Override
    Iterable<Price> getEvents() {
        return Price.list();
    }
}
