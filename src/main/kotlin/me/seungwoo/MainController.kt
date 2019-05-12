package me.seungwoo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-05-12
 * Time: 13:32
 */

@Controller
class MainController {

    @GetMapping("/")
    fun main(model: Model): String {
        model["title"] = "Main"
        return "main"
    }

}