package com.mirea.veremeev.l.m.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Employee {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
    var name : String = ""
    var salary : Int = 0
}

