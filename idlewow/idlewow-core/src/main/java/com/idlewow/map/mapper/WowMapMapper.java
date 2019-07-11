package com.idlewow.map.mapper;

import com.idlewow.com.idlewow.map.model.WowMap;
import com.idlewow.map.model.WowMap;
import com.idlewow.query.model.WowMapQueryParam;

import java.util.List;

public interface WowMapMapper {
    int insert(WowMap wowMap);

    int batchInsert(List<WowMap> list);

    int update(WowMap levelProp);

    int delete(String id);

    WowMap find(String id);

    List<WowMap> list(WowMapQueryParam queryParam);

    int count(WowMapQueryParam queryParam);
}