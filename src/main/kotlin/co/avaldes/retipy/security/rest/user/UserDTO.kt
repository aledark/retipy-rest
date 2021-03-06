/*
 * Copyright (C) 2018 - Alejandro Valdes
 *
 * This file is part of retipy.
 *
 * retipy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * retipy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with retipy.  If not, see <http://www.gnu.org/licenses/>.
 */

package co.avaldes.retipy.security.rest.user

import co.avaldes.retipy.security.domain.user.User
import co.avaldes.retipy.security.persistence.user.Role

data class UserDTO(
    val username: String,
    val identity: String,
    val password: String,
    val role: Role,
    val name: String
) {
    companion object {
        fun toDomain(userDTO: UserDTO) =
            User(
                0L,
                userDTO.identity,
                userDTO.name,
                userDTO.username,
                userDTO.password,
                mutableSetOf(userDTO.role),
                false, // a login request should be disabled/locked/expired by default.
                true,
                true)

        fun fromDomain(user: User) =
            UserDTO(user.username, user.identity, "", user.roles.first(), user.name)
    }
}
