package com.example.cst_dev41.searchuser.model

class CustomerOffline {
    var Customer: String? = null
    var code: String? = null

    constructor()

    constructor( Customer: String, code: String) {
        this.Customer = Customer
        this.code = code

    }
}