package com.mission.contentservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// DTO (데이터 모델) - 자바의 Class 대신 data class를 사용합니다.
data class Post(val id: Long, val title: String, val author: String)

@RestController
class ContentController {

    @GetMapping("/posts")
    fun getPosts(): List<Post> {
        // 하드코딩된 데이터 리턴
        return listOf(
            Post(1, "Kotlin is easy", "Developer Kim"),
            Post(2, "Spring Boot with Kotlin", "Manager Lee")
        )
    }
}