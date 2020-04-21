package com.xieyangzhe.jumper.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
@Component
public class UrlConverter {
    Map<Long, String> longUrlIdMap = new HashMap<>();
    private long autoIncrId = 56910236587L;

    public long incr() {
        return ++autoIncrId;
    }

    public String compress(String longUrl) {
        long id = incr();
        longUrlIdMap.put(id, longUrl);
        return NumberConverter.fromBase10(id);
    }

    public String extract(String shortUrl) {
        long id = NumberConverter.toBase10(shortUrl);
        return longUrlIdMap.get(id);
    }

    public void setAutoIncrId(long autoIncrId) {
        this.autoIncrId = autoIncrId;
    }
}
