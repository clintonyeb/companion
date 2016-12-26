package com.companion

import grails.transaction.Transactional

@Transactional
class NewsfeedService {

    def search(String sectionQuery) {
        if (sectionQuery) {
            def query = Newsfeed.where {
                webTitle =~ "%${sectionQuery}%" || trailText =~ "%${sectionQuery}%" || tag.sectionName =~ "%${sectionQuery}%"
            }.list()
            [newsItems: query, searchQuery: sectionQuery]
        }
    }
}
