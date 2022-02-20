package com.example.pulllist.Dao;

import com.example.pulllist.Domain.PullItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PullDao {
//    通过type区分
    public List<PullItem> pull(String type);
}
