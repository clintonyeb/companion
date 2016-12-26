package com.companion

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class NewsfeedFunctionalSpec extends GebSpec {

    void "Test the home page renders correctly"() {
        when:"The home page is visited"
        go '/'

        then:"The title is correct"
        $(".me").text() == "Clinton"
    }
}
