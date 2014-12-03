package org.ffbooking

import org.bson.types.ObjectId
//@Resource( uri = '/prices', readOnly = true, formats = [ 'json' ] )
class Price {
    ObjectId id
    Date from
    Date to
    Integer price

    static constraints = {
    }

    static mapping = {
        sort: 'from'
    }
}
