package com.example.scaffold.frameworks.test.web

import com.example.scaffold.frameworks.test.container.WithTestContainers
import com.example.scaffold.frameworks.test.moco.MocoContainer
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag("slow")
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unittest")
@WithTestContainers(containers = [MocoContainer::class])
annotation class IntegrationTest
