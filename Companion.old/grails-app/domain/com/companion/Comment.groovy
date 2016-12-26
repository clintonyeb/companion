package com.companion

class Comment {
    static hasOne = [user: User, newsfeed: Newsfeed]
    static belongsTo = [User, Newsfeed]
    String content
    int likes
    int disLikes
    Date lastUpdated
    Date dateCreated

    static constraints = {
        content blank: false, maxSize: 200
    }
    static mapping = {
        sort likes: "desc"
    }

    @Override
    String toString() {
        return content
    }
}
