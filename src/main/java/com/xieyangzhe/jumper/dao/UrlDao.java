package com.xieyangzhe.jumper.dao;

import com.xieyangzhe.jumper.model.UrlModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
@Mapper
public interface UrlDao {
    UrlModel getUrlMapByEncoded(String encoded);

    void insertUrl(UrlModel urlModel);

    String selectMax();

    void updateWhenClick(UrlModel urlModel);
}
