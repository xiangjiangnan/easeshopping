package com.netease.easeshopping.utils;

import com.netease.easeshopping.dao.UuidMapper;
import com.netease.easeshopping.model.Uuid;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;

/**
 * 用于产生唯一的商品id
 */
@Component
public class UuidUtil {
    //static long counter= new Random().nextLong();
    static Object lock = new Object();
    private  UuidMapper uuidMapper;

    public UuidUtil(UuidMapper uuidMapper){
        this.uuidMapper = uuidMapper;
    }
    public  String generate(){
        long count = 0;
        synchronized(lock){
            System.out.println("123:" + uuidMapper.getTotalCount());
            count = uuidMapper.getTotalCount();//为了保证唯一性，利用数据库来记录
            //count = ++counter;
            UUID uuid = UUID.randomUUID();
            long uuidh = uuid.getLeastSignificantBits();
            long uuidl = uuid.getLeastSignificantBits();
            ByteBuffer buff = ByteBuffer.allocate(Long.BYTES * 3);
            buff.putLong(uuidh);
            buff.putLong(uuidl);
            buff.putLong(count);
            String cid = Base64.encode(buff.array());

            Uuid uid = new Uuid();
            uid.setUuid(cid);
            uuidMapper.insert(uid);
            return cid;
        }
    }
}
