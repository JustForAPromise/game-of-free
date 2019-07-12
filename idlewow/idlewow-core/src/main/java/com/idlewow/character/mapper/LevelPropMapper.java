package com.idlewow.character.mapper;

import com.idlewow.character.model.LevelProp;
import com.idlewow.query.model.LevelPropQueryParam;

import java.util.List;

public interface LevelPropMapper {
    int insert(LevelProp levelProp);

    int batchInsert(List<LevelProp> list);

    int update(LevelProp levelProp);

    int delete(String id);

    LevelProp find(String id);

    List<LevelProp> list(LevelPropQueryParam queryParam);

    int count(LevelPropQueryParam queryParam);
}
