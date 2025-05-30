package com.example.stow

class Vehicle {
    private var _id: String,
    val hashMap = HashMap<String, Items>()

    var id: String
        get() = _id
        set(value) {
            if (value.isNotEmpty()) {
                _id = value
            }
        }

    fun addItem(i: Items) {
        hashMap.put(i.prodName, i)
    }

    fun getItem(i: Items) {
        hashMap.get(i.prodName)
    }

    fun removeItem(i: Items) {
        hashMap.remove(i.prodName)
    }
}