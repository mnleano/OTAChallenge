package com.neds.otachallenge.data.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Level(
   @Id var id: Long = 0,
   val level: Int,
   val title: String,
   val description: String,
   val state: String,

)
