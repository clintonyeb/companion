package com.companion

class User {
    String nickName
    String password
    Date dateCreated
    static hasOne = [profile: Profile]
    static hasMany = [following: User, comments: Comment]
    static scope = "session"

    static constraints = {
        nickName nullable: false, blank: false, unique: true
        password minSize: 5, blank: false, validator: { password, user ->
            password != user.nickName
        }
        following nullable: true, unique: true
        profile nullable: true, unique: true
        comments nullable: true
    }
}
