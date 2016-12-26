package com.companion

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(NewsfeedService)
@Mock([Newsfeed, Tag])
class NewsfeedServiceSpec extends Specification {
    void "NewsSearch returns results"() {
        setup: "Given a query string"
        String sectionQuery = "sport"

        when: "A search is performed"
        def model = service.search(sectionQuery)

        then: "The results must be as expected"
        model
        model.searchQuery == sectionQuery
    }
}
