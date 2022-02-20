package com.example.pulllist.Service;

import com.example.pulllist.Domain.PullItem;

import java.util.List;

public interface PullService {
    //    通过type区分
    public List<PullItem> pull(String type);
}
