package com.companion


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProfileInterceptor)
class ProfileInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test profile interceptor matching"() {
        when: "A request matches the interceptor"
        withRequest(controller: "profile")

        then: "The interceptor does match"
        interceptor.doesMatch()
    }
}
