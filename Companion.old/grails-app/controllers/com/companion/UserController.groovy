package com.companion

import com.companion.UserService.UserException

class UserController {

    static scaffold = User

    def userService

    def createUser() {}

    def loginUser() {
        try {
            userService.loginUser(params.nickName, params.password)
            redirect(controller: "newsfeed")
        } catch (UserException e) {
            flash.message = e.message
            redirect(action: 'login')
        }
    }

    def login() {}

    def newUser(String nickName, String password) {
        try {
            userService.createNewUser(nickName, password)
            redirect(controller: "newsfeed")
        } catch (UserException e) {
            flash.message = e.message
            redirect(action: 'createUser')
        }

    }

}