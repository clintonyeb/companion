package com.companion

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock([User])
class UserServiceSpec extends Specification {

    void "A new user can be created"() {
        given: "A set of credentials"
        String nickName = "clinton"
        String password = "clintonpassword"

        when: "User ois retrieved"
        def newUser = service.createNewUser(nickName, password)

        then: "The following must be true"
        newUser
        User.get(1).nickName == nickName
    }

    void "Exception is thrown with wrong credentials"() {
        given: "Null nickName"
        String nickName = null
        String password = "clintonpassword"

        when: "User is validated by service"
        def user = service.createNewUser(nickName, password)

        then: "UserException must be thrown"
        !user
        thrown(UserService.UserException)

    }

    void "User created can login"() {
        given: "An existing user"
        String nickName = "clinton"
        String password = "clintonpassword"
        service.createNewUser(nickName, password)

        when: "User tries to login"
        def user = service.loginUser(nickName, password)

        then: "The following must be true"
        user
        notThrown(UserService.UserException)

    }

    void "User attempts wih wrong credentials"() {
        given: "An existing user"
        String nickName = "clinton"
        String password = "clintonpassword"
        service.createNewUser(nickName, password)

        when: "User tries to login"
        def user = service.loginUser(nickName, 'sds')

        then: "The following must be true"
        !user
        thrown(UserService.UserException)

    }

    void "User attempts wih wrong credentials 2"() {
        given: "An existing user"
        String nickName = "clinton"
        String password = "clintonpassword"
        service.createNewUser(nickName, password)

        when: "User tries to login"
        def user = service.loginUser('ddsd', password)

        then: "The following must be true"
        !user
        thrown(UserService.UserException)

    }
}
