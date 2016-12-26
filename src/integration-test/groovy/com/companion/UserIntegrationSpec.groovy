package com.companion

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class UserIntegrationSpec extends Specification {

    void "New user can be created"() {
        setup: "A set of credentials"
        String nickName = "clintonyeb"
        String password = "clintonpass"

        when: "A new user is created and saved"
        def newUser = new User(nickName: nickName, password: password).save(failOnError: true, flush: true)

        then: "There should be one user in the database"
        2 == User.count() //One from bootstrap.groovy
        newUser.profile == null
    }

    void "A user can be created with profile"() {
        setup: "A new user profile"
        def profile = new Profile(fullName: 'Clinton Yeboah', email: "kiit@in.com")

        when: "A new user is created with the profile"
        def newUser = new User(nickName: 'nickName', password: 'password', profile: profile).save(failOnError: true,
                flush: true)

        then: "Users profile must not be null"
        newUser.profile != null
        newUser.profile.fullName == 'Clinton Yeboah'
    }

    void "A user can update his profile after creating"() {
        setup: "An existing user"
        def newUser = new User(nickName: 'nickName', password: 'password').save(failOnError: true, flush: true)

        when: "His profile is updated"
        def profile = new Profile(fullName: 'Clinton Yeboah', email: "kiit@in.com")
        newUser.profile = profile
        newUser.save()

        then: "users profile must exist"
        newUser.profile != null
        newUser.profile.fullName == 'Clinton Yeboah'

    }

    void "A user can add to a post's comments"() {
        setup: "An existing user"
        def newUser = new User(nickName: 'nickName', password: 'password').save(failOnError: true, flush: true)

        and: "A comment and a news"
        def news = new Newsfeed(webTitle: 'I Love Hillary', webPublicationDate: new Date(),
                trailText: 'Hillary can change America', webUrl: 'http:google.com', webId: '4',
                thumbnail: 'image', tag: Tag.findOrSaveBySectionName('science'))

        when: 'A user adds comment to post'
        def comm = new Comment(content: "Hillary cant be president", user: newUser, newsItem: news)
        news.addToComments(comm)
        newUser.addToComments(comm)

        then: "Newsfeed must have some comments"
        news.comments != null
        news.comments.size() > 0
        news.comments[0].user == newUser
        newUser.comments.size() == 1
        comm.user == newUser

    }

    void "Testing username contraints"() {
        setup: "A set of credentials"
        def newUser = new User(nickName: nick, password: pass)

        when: "The user is created and persisted"
        newUser.validate()

        then:
        newUser.hasErrors() == cond

        where:
        nick   | pass       | cond
        null   | 'password' | true
        'john' | 'ss'       | true
        'john' | 'sasssac'  | false
    }

    void "User can follow other users"() {
        setup: "Existing users"
        def user1 = new User(nickName: 'nick1', password: 'password').save()
        def user2 = new User(nickName: 'nick2', password: 'password').save()
        def user3 = new User(nickName: 'nick3', password: 'password').save()
        def user4 = new User(nickName: 'nick4', password: 'password').save()

        when: "Users try to follow each other"
        user1.addToFollowing(user2)
        user1.addToFollowing(user3)
        user2.addToFollowing(user1)

        then: "The number of their followers must match"
        user1.following.size() == 2
        user2.following.size() == 1
        user3.following == null
        user4.following == null

    }

    void "User cannot follow same person twice"() {
        setup: "Existing users"
        def user1 = new User(nickName: 'nick1', password: 'password').save()
        def user2 = new User(nickName: 'nick2', password: 'password').save()
        def user3 = new User(nickName: 'nick3', password: 'password').save()
        def user4 = new User(nickName: 'nick4', password: 'password').save()

        when: "Users try to follow each other"
        user1.addToFollowing(user2)
        user1.addToFollowing(user2)
        user2.addToFollowing(user1)

        then: "There must be errors in user1"
        user1.following.size() == 1
        user2.following.size() == 1
    }

    void "NickName cannot be repeated"() {
        setup: "Existing users"
        def user1 = new User(nickName: 'nick1', password: 'password')
        def user2 = new User(nickName: 'nick1', password: 'password')

        when: "Users are validated"
        user1.save()
        user2.save()


        then: "User2 must have errors"
        !user1.hasErrors()
        user2.hasErrors()
    }

    void "A Post must have store new tags only when its different"() {
        setup: "A set of posts"
        def news = new Newsfeed(webTitle: 'I Love Hillary', webPublicationDate: new Date(),
                trailText: 'Hillary can change America', webUrl: 'http:google.com', webId: '4',
                thumbnail: 'image', tag: Tag.findOrSaveWhere(sectionName: 'spring'))
        def news2 = new Newsfeed(webTitle: 'I Love John', webPublicationDate: new Date(),
                trailText: 'John can change America', webUrl: 'http:giigle.com', webId: '10',
                thumbnail: 'image', tag: Tag.findOrSaveWhere(sectionName: 'spring'))
        def news3 = new Newsfeed(webTitle: 'I Love Michael', webPublicationDate: new Date(),
                trailText: 'Michale can change America', webUrl: 'http:ghhgle.com', webId: '9',
                thumbnail: 'image', tag: Tag.findOrSaveWhere(sectionName: 'springing'))

        when: "Posts are saved"
        news.save(failOnError: true)
        news2.save(failOnError: true)
        news3.save(failOnError: true)

        then: "Number of Tags saved must be 2"
        !news.hasErrors()
        !news2.hasErrors()
        !news3.hasErrors()
        Tag.count() == 7 //Due to 5 from bootsrap.groovy
    }


}
