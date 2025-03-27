package com.devtools.sphere.Model.Data_Base

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import kotlin.jvm.java


@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name ="first_name") val firstName: String?,
    @ColumnInfo(name="last_name") val lastName: String?

)



