package org.ffbooking

class Callback {
    String name
    String phone
    String address
    String comment
    Date bookDate
    Integer price
    String childrenAges
    String bookPeriod

    Date bookedAt = new Date()
    Boolean done = false

    static constraints = {
        [ 'address', 'comment', 'bookDate', 'price', 'childrenAges', 'bookPeriod' ].each {
            "$it" nullable: true
        }
    }
}
