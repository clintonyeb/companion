package com.companion

class Newsfeed {

    String webTitle
    String webPublicationDate;
    String trailText;
    String webUrl;
    String thumbnail;
    String webId;
    Date dateCreated
    static hasMany = [comments: Comment]
    static hasOne = [tag: Tag]

    static constraints = {
        tag null: false
        comments nullable: true
        webTitle blank: false
        webPublicationDate null: false
        trailText blank: false
        webUrl blank: false
        thumbnail null: false
        webId blank: false
    }

    static mapping = {
        sort dateCreated: "desc"
    }
}
