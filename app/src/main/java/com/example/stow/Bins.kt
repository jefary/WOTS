package com.example.stow

class Bins {
    private var _name: String = ""
    val hashMap = HashMap<String, Items>()

    var name: String
        get() = _name
        set(value) {
            if (value.isNotEmpty()) {
                _name = value
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