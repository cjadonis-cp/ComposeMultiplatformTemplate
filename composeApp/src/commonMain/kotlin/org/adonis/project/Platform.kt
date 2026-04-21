package org.adonis.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform