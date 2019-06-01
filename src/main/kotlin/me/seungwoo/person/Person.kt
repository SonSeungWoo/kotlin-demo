package me.seungwoo.person

import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr

/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-06-01
 * Time: 15:45
 */
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {

    val persons = listOf(Person("seungwoo"),
            Person("wonwoo", age = 50))

    val oldest = persons.maxBy { it.age ?: 0 }

    print("나이 많은 사람: $oldest")

    print(renderPersonList(persons))
}

fun renderPersonList(persons: Collection<Person>) =
        createHTML().table {
            for (person in persons) {
                tr {
                    td {+person.name}
                    td {person.age}
                }
            }
        }

