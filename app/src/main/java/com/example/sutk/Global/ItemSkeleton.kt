package com.example.sutk.com.example.sutk.Global

public class ItemSkeleton(lable: String, icon: Int, description: String, descriptionSmall: String, id: Int, authorName: String, authorTelegram: String, author: Int) {
    public var label: String? = null
    public var icon: Int? = null
    public var description: String? = null
    public var descriptionSmall: String? = null
    public var id: Int? = null
    public var authorName: String? = null
    public var authorTelegram: String? = null
    public var author: Int? = null
    public var contributorsName: MutableList<String>? = null
    public var contributorsTelegram: MutableList<String>? = null
    public var contributors: MutableList<Int>? = null
    public var tags: MutableList<Int>? = null

    constructor(lable: String, icon: Int, descriptionSmall: String, id: Int) : this(lable = lable, icon, description = descriptionSmall, descriptionSmall, id, "Мистер Никто", "TWNTxygen", 0) {
        this.label = label
        this.icon = icon
        this.descriptionSmall = descriptionSmall
        this.id = id
    }


//    public fun inflateTags(tags: MutableList<Int>){
//        this.tags = tags
//    }
}