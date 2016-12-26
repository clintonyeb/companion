package com.clinton


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class NewsfeedIntSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "adding comments to news"() {
        when: "News Item already exists"
        def news2 = new Newsfeed(webId: 'sport/live/2jjjj016/jul/30/us-pga-championship-2016-third-round-live',
                tag: Tag.findOrSaveWhere(sectionName: 'sport'), webPublicationDate: '2016-07-30T18:03:01Z',
                webTitle: 'US PGA Championship 2016: third round – live!',
                webUrl: 'https://www.theguardinnan.com/sport/live/2016/jul/30/us-pga-championship-2016-third-round-live',
                trailText: 'Follow all the action from day three at Baltusrol, with Scott Murray',
                thumbnail: 'https://media.guim.co.uk/f239e3bebb414077e9fce4e0cc2f09fe6edafc88/1162_778_3626_2175/500.jpg'
        ).save(failOnError: true);
        def user = new User(nickName: 'clinton1', password: 'clintonpassword').save(failOnError: true);

        and: "A comment is also created"
        def comment = new Comment(content: 'I miss you here', user: user);
        news2.addToComments(comment)

        then: "The following must true"
        news2 == Newsfeed.get(1)
        comment == Newsfeed.get(1).comments[0]
        user == Newsfeed.get(1).comments[0].user
    }
}
