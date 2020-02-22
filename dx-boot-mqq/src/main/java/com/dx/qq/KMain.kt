package com.dx.qq

import net.mamoe.mirai.Bot
import net.mamoe.mirai.BotAccount
import net.mamoe.mirai.alsoLogin
import java.io.File

/**
 * Description: com.dx.qq
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/1/30
 */
class KMain {

    suspend fun test() {
        val bot = Bot(123,"qq密码").alsoLogin();
    }

    private fun readTestAccount(): BotAccount? {
        val file = File("E:\\tup\\testAccount.txt")
        if (!file.exists() || !file.canRead()) {
            return null
        }

        val lines = file.readLines()
        return try {
            BotAccount(lines[0].toLong(), lines[1])
        } catch (e: Throwable) {
            null
        }
    }

}
