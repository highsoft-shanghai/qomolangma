package com.qomolangma.frameworks.test.moco

import com.github.dreamhead.moco.MocoRequestHit.requestHit
import com.github.dreamhead.moco.RequestHit

object MocoHit {
    private val IMPL = requestHit()

    @JvmStatic
    fun hit(): RequestHit {
        return IMPL
    }
}
