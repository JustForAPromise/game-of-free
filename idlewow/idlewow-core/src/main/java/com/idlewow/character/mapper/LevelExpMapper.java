package com.idlewow.character.mapper;


import com.idlewow.character.model.LevelExp;
import com.idlewow.query.model.LevelExpQueryParam;

import java.util.List;

public interface LevelExpMapper {
    int insert(LevelExp levelExp);

    int batchInsert(List<LevelExp> list);

    int update(LevelExp levelExp);

    int delete(String id);

    LevelExp find(String id);

    List<LevelExp> list(LevelExpQueryParam queryParam);

    int count(LevelExpQueryParam queryParam);
}
