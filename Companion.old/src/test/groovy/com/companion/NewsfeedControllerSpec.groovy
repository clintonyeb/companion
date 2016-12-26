package com.companion

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(NewsfeedController)
@Mock([Newsfeed, Tag])
class NewsfeedControllerSpec extends Specification {
    void "News can be fetched"() {
        setup: "A mock service"
        def mockNewsService = Mock(NewsfeedService)
        1 * mockNewsService.search(_) >>
                new Newsfeed(webId: '1', webTitle: 'Collins Migah', webPublicationDate: new Date(),
                        webUrl: 'http://google.com', trailText: 'Good Boy', thumbnail: 'Images',
                        Tag: new Tag(sectionName: 'Test'))
        controller.newsfeedService = mockNewsService

        when: "controller is invoked"
        def results = controller.search('from frank')

        then: "Results must contain one news item"
        results
        results.webId == '1'
    }
}