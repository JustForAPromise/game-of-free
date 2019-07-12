package com.idlewow.mob.mapper;

import com.idlewow.mob.model.MapMob;
import com.idlewow.query.model.MapMobQueryParam;

import java.util.List;

public interface MapMobMapper {
    int insert(MapMob mapMob);

    int batchInsert(List<MapMob> list);

    int update(MapMob mapMob);

    int delete(String id);

    MapMob find(String id);

    List<MapMob> list(MapMobQueryParam queryParam);

    int count(MapMobQueryParam queryParam);
}
