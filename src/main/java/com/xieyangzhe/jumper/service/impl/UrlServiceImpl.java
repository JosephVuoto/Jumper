package com.xieyangzhe.jumper.service.impl;

import com.xieyangzhe.jumper.dao.UrlDao;
import com.xieyangzhe.jumper.model.UrlModel;
import com.xieyangzhe.jumper.service.AsyncService;
import com.xieyangzhe.jumper.service.UrlService;
import com.xieyangzhe.jumper.util.LRUCache;
import com.xieyangzhe.jumper.util.NumberConverter;
import com.xieyangzhe.jumper.util.UrlConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Resource
    AsyncService asyncService;
    @Resource
    private UrlDao urlDao;
    @Resource
    private UrlConverter urlConverter;
    @Value("${server.host}")
    private String host;
    private LRUCache<String, UrlModel> recentUsed = new LRUCache<>(128);

    @Override
    public String createUrl(String url) {
        return createUrl(url, false, "");
    }

    @Override
    public String createUrl(String url, boolean hasPassword, String password) {
        String encoded = urlConverter.compress(url);
        UrlModel urlModel = new UrlModel();
        urlModel.setUrl(url);
        urlModel.setHasPassword(hasPassword);
        urlModel.setPassword(password);
        urlModel.setEncoded(encoded);
        urlDao.insertUrl(urlModel);
        recentUsed.put(encoded, urlModel);
        return host + "/" + encoded;
    }

    @Override
    public UrlModel getUrlModel(String encoded) {
        UrlModel urlModel;
        if (recentUsed.containsKey(encoded)) {
            urlModel = recentUsed.get(encoded);
        } else {
            urlModel = urlDao.getUrlMapByEncoded(encoded);
            recentUsed.put(encoded, urlModel);
        }
        recentUsed.put(encoded, urlModel);
        urlModel.setViewCount(urlModel.getViewCount() + 1);
        asyncService.update(urlModel);
        return urlModel;
    }

    @Override
    public void loadId() {
        urlConverter.setAutoIncrId(NumberConverter.toBase10(urlDao.selectMax()));
    }
}
