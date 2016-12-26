package com.companion

import grails.transaction.Transactional

@Transactional
class UserService {

    def createNewUser(String nickName, String password) {
        User user = new User(nickName: nickName, password: password)
        if (user.validate()) {
            if (user.save()) {
                [user: user]
            } else throw new UserException(message: "Error saving Data", user: user)
        } else throw new UserException(message: "Invalid Credentials", user: null)
    }

    def loginUser(String nickName, String password) {
        User user = User.where {
            nickName == nickName && password == password
        }.find()
        if (user) {
            [user: user]
        } else throw new UserException(message: 'Invalid Credentials', user: null)
    }

    class UserException extends RuntimeException {
        String message
        User user
    }
}
