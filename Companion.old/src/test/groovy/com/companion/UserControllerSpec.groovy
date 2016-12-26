package com.companion

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(UserController)
@Mock([User, UserService])
class UserControllerSpec extends Specification {

    void "Creating a new user"() {
        given: "A set of credentials"
        String nickName = 'nickname'
        String password = 'yourpassword'

        and: "A mocked service"
        def mockService = Mock(UserService)
        1 * mockService.createNewUser(nickName, password) >> new User(nickName: nickName, password: password)
        controller.userService = mockService

        when: "Controller is invoked"
        def user = controller.newUser(nickName, password)

        then: "The following must be true"
        response.redirectedUrl == "/newsfeed"

    }


    void "Creating user with service mocking"(){
        given: "User and mocked service"
        UserService uService =  Mock()
        controller.userService = uService

        when: "Controller tries to save"
        def user = controller.newUser('Clinton', 'goodnameisbetter')

        then: "Following must be true"
        1 * uService.createNewUser(_, _) >> new User(nickName: 'nickname', password: 'passwordhere')
        response.redirectedUrl == "/newsfeed"

    }

}