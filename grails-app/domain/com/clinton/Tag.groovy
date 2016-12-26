package com.clinton

class Tag {

    String sectionName
    static hasMany = [newsfeed: Newsfeed]
    static belongsTo = Newsfeed
    static constraints = {
        sectionName blank: false, null: false, unique: true
        newsfeed unique: true
    }

    @Override
    String toString() {
        return sectionName
    }
}
