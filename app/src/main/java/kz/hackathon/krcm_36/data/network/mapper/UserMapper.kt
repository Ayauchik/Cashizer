package kz.hackathon.krcm_36.data.network.mapper

import kz.hackathon.krcm_36.data.network.response.UserResponse
import kz.hackathon.krcm_36.domain.model.User

class UserMapper {
    fun fromRemoteToDomain(userResponse: UserResponse): User {
        return User(
            id = userResponse.id,
            name = userResponse.name,
            surname = userResponse.surname,
            email = userResponse.email,
            address = userResponse.address,
            phone = userResponse.phone
        )
    }
}