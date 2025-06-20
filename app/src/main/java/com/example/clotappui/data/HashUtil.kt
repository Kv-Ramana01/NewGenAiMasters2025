package com.example.clotappui.data

import java.security.MessageDigest

object HashUtil {
    fun sha256(input: String): String {
        return MessageDigest
            .getInstance("SHA-256")
            .digest(input.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}
