package com.android.example.appexamen.model

data class Category(

    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String,

)


//{"categories":["food"],
//    "created_at":"2020-01-05 13:42:18.823766",
//    "icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png",
//    "id":"tnsit4iqsk2fe7ohwk1qgq",
//    "updated_at":"2020-01-05 13:42:18.823766",
//    "url":"https://api.chucknorris.io/jokes/tnsit4iqsk2fe7ohwk1qgq",
//    "value":"Chuck Norris owns a chain of fast-food restaurants throughout the southwest. They serve nothing but barbecue-flavored ice cream and Hot Pockets."}