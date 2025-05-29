package com.example.stow

class Items (
    var _prodName: String,
    var _prodCategory: String,
    var _prodImg: String,
    var _prodLocation: String
) {
    var prodName: String
        get() = _prodName
        set(value) {
            if (value.isNotEmpty()) {
                _prodName = value
            }
        }

    var prodCategory: String
        get() = _prodCategory
        set(value) {
            if (value.isNotEmpty()) {
                _prodCategory = value
            }
        }

    var prodImg: String
        get() = _prodImg
        set(value) {
            if (value.isNotEmpty()) {
                _prodImg = value
            }
        }

    var prodLocation: String
        get() = _prodLocation
        set(value) {
            if (value.isNotEmpty()) {
                _prodLocation = value
            }
        }
}