package com.mao.util;

import java.util.Random;

/**
 * Author: Administrator
 * Date: 2021/6/16 21:28
 * Description:生成随机订单编号
 */
public class KeyUtil {
    public static synchronized String createUniqueKey(){
        Random random = new Random();
        int key = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
