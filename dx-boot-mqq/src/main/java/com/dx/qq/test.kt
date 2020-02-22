package com.dx.qq

import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin

/**
 * Description: com.dx.qq
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/2/23
 */
suspend fun main() {
    val bot = Bot(123,"qq密码").alsoLogin();
}
