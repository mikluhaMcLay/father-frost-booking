package org.ffbooking

import org.bson.types.ObjectId

class Price {
    ObjectId id
    Date from
    Date to
    Integer price
    String type

    static constraints = {
        type nullable: true
    }

    static mapping = {
        sort: 'from'
    }
}
