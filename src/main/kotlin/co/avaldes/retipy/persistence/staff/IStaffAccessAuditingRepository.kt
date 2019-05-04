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

package co.avaldes.retipy.persistence.staff

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface IStaffAccessAuditingRepository : PagingAndSortingRepository<StaffAccessAuditingBean, Long>, JpaSpecificationExecutor<StaffAccessAuditingBean> {
    fun findByAuditingOperation(auditingOperation: AuditingOperation): List<StaffAccessAuditingBean>
    fun findByResourceId(resourceId: Long): List<StaffAccessAuditingBean>
    fun findByUserId(userId: Long): List<StaffAccessAuditingBean>
}
