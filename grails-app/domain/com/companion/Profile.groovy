package com.companion

class Profile {
    String fullName
    String email
    byte[] avatar
    String status
    String gender
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user: User]

    static constraints = {
        fullName blank: false
        email email: true
        gender nullable: true, inList: ['Male', 'Female']
        status nullable: true
        avatar nullable: true
    }

}
