package com.idlewow.character.manager;

import com.idlewow.character.mapper.LevelPropMapper;
import com.idlewow.character.model.LevelProp;
import com.idlewow.common.model.PageList;
import com.idlewow.query.model.LevelPropQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LevelPropManager {
    @Autowired
    LevelPropMapper levelPropMapper;

    public void insert(LevelProp levelProp) {
        int effected = levelPropMapper.insert(levelProp);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void batchInsert(List<LevelProp> list) {
        int splitSize = 100;
        int index = 0;
        int total = list.size();
        while (index <= total) {
            int end = index + splitSize;
            if (end > total) {
                end = total;
            }

            List<LevelProp> sublist = list.subList(index, end);
            int effected = levelPropMapper.batchInsert(sublist);
            if (effected == 0) {
                throw new RuntimeException("sql effected 0 rows");
            }

            index += splitSize;
        }
    }

    public void update(LevelProp levelProp) {
        int effected = levelPropMapper.update(levelProp);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public void delete(String id) {
        int effected = levelPropMapper.delete(id);
        if (effected == 0) {
            throw new RuntimeException("sql effected 0 rows");
        }
    }

    public LevelProp find(String id) {
        LevelProp levelProp = levelPropMapper.find(id);
        return levelProp;
    }

    public PageList<LevelProp> list(LevelPropQueryParam queryParam) {
        PageList<LevelProp> pageList = new PageList<LevelProp>();
        int count = levelPropMapper.count(queryParam);
        List<LevelProp> list = levelPropMapper.list(queryParam);
        pageList.setTotalCount(count);
        pageList.setData(list);
        pageList.setPageParam(queryParam.getPageParam());
        return pageList;
    }
}
