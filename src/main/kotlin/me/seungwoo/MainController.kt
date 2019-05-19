package me.seungwoo

import me.seungwoo.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-05-12
 * Time: 13:32
 */

@Controller
class MainController(@Autowired private val accountRepository: AccountRepository) {

    @GetMapping("/")
    fun main(model: Model): String {
        model["title"] = "Main"
        return "main"
    }

    @RequestMapping("/success")
    fun success(request: HttpServletRequest): String {
        return "success"
    }

    @GetMapping("/{email}")
    @ResponseBody
    fun findByLastName(@PathVariable email: String) = accountRepository.findByEmail(email)

}
