package com.plush.lancet.demo

import com.plush.lancet.base.Origin
import com.plush.lancet.base.annotations.Proxy
import com.plush.lancet.base.annotations.TargetClass

/**
 * Desc:
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
class HookClass {
    companion object {
        @Proxy("i")
        @TargetClass("android.util.Log")
        fun anyName(tag: String, msg: String): Int? {
            "$msg lancet"
            return Origin.call() as? Int
        }
    }
}