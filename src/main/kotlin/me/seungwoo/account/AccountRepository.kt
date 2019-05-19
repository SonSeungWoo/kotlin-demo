package me.seungwoo.account

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-05-19
 * Time: 16:26
 */
interface AccountRepository: JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
}
