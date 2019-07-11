package com.idlewow.map.manager;

import com.idlewow.com.idlewow.map.model.WowMap;
import com.idlewow.common.model.PageList;
import com.idlewow.map.mapper.WowMapMapper;
import com.idlewow.map.model.WowMap;
import com.idlewow.query.model.WowMapQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WowMapManager {

    @Autowired
    WowMapMapper wowMapMapper;

    public void insert(WowMap wowMap) {
        int effected = wowMapMapper.insert(wowMap);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void batchInsert(List<WowMap> list) {
        int splitSize = 100;
        int index = 0;
        int total = list.size();
        while (index <= total) {
            int end = index + splitSize;
            if (end > total) {
                end = total;
            }

            List<WowMap> sublist = list.subList(index, end);
            int effected = wowMapMapper.batchInsert(sublist);
            if (effected == 0) {
                throw new RuntimeException("sql effected 0 rows");
            }

            index += splitSize;
        }
    }

    public void update(WowMap t) {
        int effected = wowMapMapper.update(t);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void delete(String id) {
        int effected = wowMapMapper.delete(id);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public WowMap find(String id) {
        WowMap wowMap = wowMapMapper.find(id);
        return wowMap;
    }

    public PageList<WowMap> list(WowMapQueryParam queryParam) {
        PageList<WowMap> pageList = new PageList<WowMap>();
        int count = wowMapMapper.count(queryParam);
        List<WowMap> list = wowMapMapper.list(queryParam);
        pageList.setTotalCount(count);
        pageList.setData(list);
        pageList.setPageParam(queryParam.getPageParam());
        return pageList;
    }
}