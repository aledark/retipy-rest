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

package co.avaldes.retipy.security.domain.user

import co.avaldes.retipy.security.persistence.user.UserBean
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class User(
    val id: Long,
    val identity: String,
    val name: String,
    private val username: String,
    private val password: String,
    val enabled: Boolean,
    val locked: Boolean,
    val expired: Boolean
) : UserDetails
{
    companion object
    {
        fun fromPersistence(userBean: UserBean) = User(
            userBean.id,
            userBean.identity,
            userBean.name,
            userBean.username,
            userBean.password,
            userBean.enabled,
            userBean.locked,
            userBean.expired)

        fun toPersistence(user: User) = UserBean(
            user.id,
            user.identity,
            user.name,
            user.username,
            user.password,
            user.enabled,
            user.locked,
            user.expired)
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>
    {
        return mutableListOf()
    }

    override fun isEnabled() = enabled

    override fun getUsername() = username

    override fun isCredentialsNonExpired() = !expired

    override fun getPassword() = password

    override fun isAccountNonExpired() = !expired

    override fun isAccountNonLocked() = !locked
}