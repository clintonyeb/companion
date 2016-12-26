package com.companion

class NewsfeedController {

    static scaffold = Newsfeed
    def newsfeedService

    def search(String sectionQuery) {
        newsfeedService.search(sectionQuery)
    }
}
