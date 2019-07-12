package com.idlewow.character.manager;

import com.idlewow.character.mapper.LevelExpMapper;
import com.idlewow.character.model.LevelExp;
import com.idlewow.common.model.PageList;
import com.idlewow.query.model.LevelExpQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LevelExpManager {
    @Autowired
    LevelExpMapper levelExpMapper;

    public void insert(LevelExp levelExp) {
        int effected = levelExpMapper.insert(levelExp);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void batchInsert(List<LevelExp> list) {
        int splitSize = 100;
        int index = 0;
        int total = list.size();
        while (index <= total) {
            int end = index + splitSize;
            if (end > total) {
                end = total;
            }

            List<LevelExp> sublist = list.subList(index, end);
            int effected = levelExpMapper.batchInsert(sublist);
            if (effected == 0) {
                throw new RuntimeException("sql effected 0 rows");
            }

            index += splitSize;
        }
    }

    public void update(LevelExp levelExp) {
        int effected = levelExpMapper.update(levelExp);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void delete(String id) {
        int effected = levelExpMapper.delete(id);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public LevelExp find(String id) {
        LevelExp levelExp = levelExpMapper.find(id);
        return levelExp;
    }

    public PageList<LevelExp> list(LevelExpQueryParam queryParam) {
        PageList<LevelExp> pageList = new PageList<LevelExp>();
        int count = levelExpMapper.count(queryParam);
        List<LevelExp> list = levelExpMapper.list(queryParam);
        pageList.setTotalCount(count);
        pageList.setData(list);
        pageList.setPageParam(queryParam.getPageParam());
        return pageList;
    }
}
