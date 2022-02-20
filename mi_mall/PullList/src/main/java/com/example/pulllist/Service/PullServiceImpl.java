package com.example.pulllist.Service;

import com.example.pulllist.Dao.PullDao;
import com.example.pulllist.Domain.PullItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PullServiceImpl implements PullService {
    @Autowired
    PullDao pullDao;
    @Override
    public List<PullItem> pull(String type) {
        return pullDao.pull(type);
    }
}
