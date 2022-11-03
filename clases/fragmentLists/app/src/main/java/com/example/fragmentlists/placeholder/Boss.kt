package com.example.fragmentlists.placeholder

import java.util.ArrayList

object BossContent{
    val ITEMS: MutableList<BossItem> = ArrayList()
    data class BossItem(val hp: String, val name: String)

}

