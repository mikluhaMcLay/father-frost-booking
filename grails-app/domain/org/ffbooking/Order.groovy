package org.ffbooking

class Order {
    String contactName
    String phone
    String address
    String comment
    Date bookDate
    Integer duration //1 means 0,5 hour
    Integer price
    List<Integer> childrenAges
    Date bookedAt

    static constraints = {
    }
}
