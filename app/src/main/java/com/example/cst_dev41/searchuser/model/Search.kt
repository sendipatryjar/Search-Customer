package com.example.cst_dev41.searchuser.model


class Search {

    var id: Int? = null
    var company: String? = null
    var code: String? = null

    var nama1: String? = null
    var jabatan1: String? = null
    var email1: String? = null
    var status1: String? = null

    var nama2: String? = null
    var jabatan2: String? = null
    var email2: String? = null
    var status2: String? = null

    var nama3: String? = null
    var jabatan3: String? = null
    var email3: String? = null
    var status3: String? = null

    var nama4: String? = null
    var jabatan4: String? = null
    var email4: String? = null
    var status4: String? = null
//    var status: String? = null
//    var email: String? = null

    constructor( company: String, code: String,
                 nama1: String, jabatan1: String, email1: String, status1: String,
                 nama2: String, jabatan2: String, email2: String, status2: String,
                 nama3: String, jabatan3: String, email3: String, status3: String,
                 nama4: String, jabatan4: String, email4: String, status4: String) {
        this.company = company
        this.code = code
        this.nama1 = nama1
        this.jabatan1 = jabatan1
        this.email1 = email1
        this.status1 = status1

        this.nama2 = nama2
        this.jabatan2 = jabatan2
        this.email2 = email2
        this.status2 = status2

        this.nama3 = nama3
        this.jabatan3 = jabatan3
        this.email3 = email3
        this.status3 = status3

        this.nama4 = nama4
        this.jabatan4 = jabatan4
        this.email4 = email4
        this.status4 = status4
    }

}