package com.example.frameworks.domain.core

import com.fasterxml.uuid.Generators
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class UuidBasedIdGenerator : IdGenerator {
    override fun next(): String {
        return UUID.randomUUID().toString().lowercase(Locale.getDefault()).replace("-", "")
    }

    override fun nextReadable(): String {
        val uuid = Generators.timeBasedGenerator().generate()
        return formatUuidTimestamp(uuid.timestamp())
    }

    private fun formatUuidTimestamp(timestamp: Long): String {
        return FORMATTER.format(
            Instant.ofEpochSecond(timestamp / A - B, timestamp % C * D).atZone(ZoneOffset.ofHours(E))
        )
    }

    companion object {
        private val FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSSS")
        private const val A: Long = 10000000
        private const val B = 12219292800L
        private const val C: Long = 1000000
        private const val D: Long = 100
        private const val E = 8
    }
}
