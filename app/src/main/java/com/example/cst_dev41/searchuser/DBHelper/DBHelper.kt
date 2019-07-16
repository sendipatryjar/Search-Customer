package com.example.cst_dev41.searchuser.DBHelper


import android.content.Context
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteQueryBuilder
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import android.database.sqlite.SQLiteDatabase
import android.support.v7.widget.SearchView
import android.util.Log
import com.example.cst_dev41.searchuser.model.Search


class DBHelper(ctx: Context): SQLiteAssetHelper(ctx, DB_NAME,null, DB_VER) {

    companion object {

        private val DB_NAME = "Username.db"
        private val DB_VER = 1

        private val TBL_NAME = "Customer"
        private val COL_DATA = "CODE"
        private val COL_NAME = "CUSTOMER"
        private val COL_NAME1 = "NAMA1"
        private val COL_JABATAN1 = "JABATAN1"
        private val COL_EMAIL1 = "EMAIL1"
        private val COL_STATUS1 = "STATUS1"
        private val COL_NAME2 = "NAMA2"
        private val COL_JABATAN2 = "JABATAN2"
        private val COL_EMAIL2 = "EMAIL2"
        private val COL_STATUS2 = "STATUS2"
        private val COL_NAME3 = "NAMA3"
        private val COL_JABATAN3 = "JABATAN3"
        private val COL_EMAIL3 = "EMAIL3"
        private val COL_STATUS3 = "STATUS3"
        private val COL_NAME4 = "NAMA4"
        private val COL_JABATAN4 = "JABATAN4"
        private val COL_EMAIL4 = "EMAIL4"
        private val COL_STATUS4 = "STATUS4"
//        private val COL_STATUS = "STATUS"
//        private val COL_EMAIL = "EMAIL"

    }

    @Throws(SQLiteException::class)
    fun getCode(query: String?): String? {
        if (query != null) {

            val db = this.writableDatabase
            val qb = SQLiteQueryBuilder()

            val sqlSelect = arrayOf(COL_NAME)
            qb.tables = TBL_NAME

            val c = qb.query(db, sqlSelect, "CUSTOMER = ?", arrayOf(query.toUpperCase()), null, null, null)
            Log.d("error","masuk nih"+query)
            var result: String? = null
            try {
                if (c.moveToFirst()) {
                    do {
                        result = c.getString(c.getColumnIndex(COL_DATA))
                    } while (c.moveToNext())
                }
            } finally {
                c.close()
            }
            return result
        } else {

        }
        return query


    }

  /*Menampilkan Semua data yang tersimpan kedalam list RecycleView pada database Tabel doNumber*/
//    fun getSemuaData(): ArrayList<Search> {
//        val dataList = ArrayList<Search>()
//        val selectQuery = "SELECT * FROM $TBL_NAME"
//
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(selectQuery, null)
//
//        if (cursor.moveToFirst()) {
//            do {
//                val dataOffline = Search(cursor.getString(1), cursor.getString(2))
//                dataList.add(dataOffline)
//                Log.d("error","apa ini "+cursor.getString(1) + "____" +  cursor.getString(2))
//            } while (cursor.moveToNext())
//        }
//        return dataList
//    }

//    fun searchData(): ArrayList<Search> {
//        val dataList = ArrayList<Search>()
//        val selectQuery = "SELECT * FROM $TBL_NAME"
//
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(selectQuery, null)
//
//        if (cursor.moveToFirst()) {
//            do {
//                val dataOffline = Search(cursor.getString(1), cursor.getString(2))
//                dataList.add(dataOffline)
//                Log.d("error","apa ini "+cursor.getString(1) + "____" +  cursor.getString(2))
//            } while (cursor.moveToNext())
//        }
//        return dataList
//    }

    fun search(keyword: String): ArrayList<Search>? {
        var contacts: ArrayList<Search>? = null
        try {
            val sqLiteDatabase = readableDatabase
            val cursor = sqLiteDatabase.rawQuery("select * from $TBL_NAME where $COL_NAME like ?", arrayOf("%$keyword%"))
            if (cursor.moveToFirst()) {
                contacts = ArrayList<Search>()
                do {
                    val dataOffline = Search(cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7),
                            cursor.getString(8),
                            cursor.getString(9),
                            cursor.getString(10),
                            cursor.getString(11),
                            cursor.getString(12),
                            cursor.getString(13),
                            cursor.getString(14),
                            cursor.getString(15),
                            cursor.getString(16),
                            cursor.getString(17),
                            cursor.getString(18)
                            )
                    contacts.add(dataOffline)
                } while (cursor.moveToNext())
            }
        } catch (e: Exception) {
            contacts = null
        }

        return contacts
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TBL_NAME")
        onCreate(db)
    }

}