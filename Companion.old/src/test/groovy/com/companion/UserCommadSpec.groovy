package com.companion

import grails.test.mixin.TestMixin
import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll

@TestMixin(ControllerUnitTestMixin)
class UserCommadSpec extends Specification {

    @Unroll
    void "Verify that user can be authenticated via command object"() {
        given: "a mocked command object"
        def cmobj = mockCommandObject(UserCommand)

        and: "A set of initial values"
        cmobj.nickName = nickName
        cmobj.password = password
        cmobj.passwordRepeat = passwordRepeat

        when: "The registration is validated"
        def val = cmobj.validate()

        then: "The following must be true"
        val == anticipated

        where:
        nickName | password          | passwordRepeat         | anticipated
        'clin'   | 'clintonpassword' | 'clintonpassword'      | true
        'clint'  | 'clintonuserpass' | 'not-matchingpassword' | false
    }
}