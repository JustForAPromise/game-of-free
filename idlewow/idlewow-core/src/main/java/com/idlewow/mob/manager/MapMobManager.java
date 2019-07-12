package com.idlewow.mob.manager;


import com.idlewow.common.model.PageList;
import com.idlewow.mob.mapper.MapMobMapper;
import com.idlewow.mob.model.MapMob;
import com.idlewow.query.model.MapMobQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapMobManager {
    @Autowired
    MapMobMapper mapMobMapper;

    public void insert(MapMob mapMob) {
        int effected = mapMobMapper.insert(mapMob);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void batchInsert(List<MapMob> list) {
        int splitSize = 100;
        int index = 0;
        int total = list.size();
        while (index <= total) {
            int end = index + splitSize;
            if (end > total) {
                end = total;
            }

            List<MapMob> sublist = list.subList(index, end);
            int effected = mapMobMapper.batchInsert(sublist);
            if (effected == 0) {
                throw new RuntimeException("sql effected 0 rows");
            }

            index += splitSize;
        }
    }

    public void update(MapMob mapMob) {
        int effected = mapMobMapper.update(mapMob);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void delete(String id) {
        int effected = mapMobMapper.delete(id);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public MapMob find(String id) {
        MapMob mapMob = mapMobMapper.find(id);
        return mapMob;
    }

    public PageList<MapMob> list(MapMobQueryParam queryParam) {
        PageList<MapMob> pageList = new PageList<MapMob>();
        int count = mapMobMapper.count(queryParam);
        List<MapMob> list = mapMobMapper.list(queryParam);
        pageList.setTotalCount(count);
        pageList.setData(list);
        pageList.setPageParam(queryParam.getPageParam());
        return pageList;
    }
}
