package com.netease.easeshopping.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;

/**
 * 用于产生唯一的商品id
 */
public class UuidUtil {
    static long counter= new Random().nextLong();
    static Object lock = new Object();
    public static String generate(){
        long count;
        synchronized(lock){
            count = ++counter;
        }
        UUID uuid = UUID.randomUUID();
        long uuidh = uuid.getLeastSignificantBits();
        long uuidl = uuid.getLeastSignificantBits();

        ByteBuffer buff = ByteBuffer.allocate(Long.BYTES*3);
        buff.putLong(uuidh);
        buff.putLong(uuidl);
        buff.putLong(count);
        return Base64.encode(buff.array());
    }
}
