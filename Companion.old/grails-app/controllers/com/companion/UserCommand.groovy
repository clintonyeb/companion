package com.companion

import grails.validation.Validateable

class UserCommand implements Validateable {

    String nickName
    String password
    String passwordRepeat

    static constraints = {
        importFrom(User)

        password minSize: 5, blank: false, validator: { password, user ->
            password != user.nickName
        }

        passwordRepeat nullable: false, blank: false, validator: { pass2, user ->
            pass2 == user.password
        }
    }
}

