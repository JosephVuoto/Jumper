package com.xieyangzhe.jumper.service;

import com.xieyangzhe.jumper.model.UrlModel;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
public interface UrlService {
    String createUrl(String url);

    String createUrl(String url, boolean hasPassword, String password);

    UrlModel getUrlModel(String encoded);

    void loadId();
}
