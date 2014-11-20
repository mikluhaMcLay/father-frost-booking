package org.ffbooking

import grails.rest.Resource

@Resource( uri = '/order', formats = [ 'json' ] )
class Order {
    String name
    String phone
    String address
    String comment
    Date bookDate
    Integer duration = 1//1 means 0,5 hour
    Integer price
    String childrenAges
    Date bookedAt = new Date()

    static constraints = {
    }
}
