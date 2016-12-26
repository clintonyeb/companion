package com.companion


class AvatarUploadCommand {
    byte[] avatar
    String nickName
}

class ImageController {

    def index() {}

    def upload(AvatarUploadCommand avatarCommand) {
        def user = User.findByNickName(avatarCommand.nickName)
        if (user) {
            user.profile.avatar = avatarCommand.avatar
            redirect(controller: 'profile', action: 'index', id: avatarCommand.nickName)
        }
    }
}
