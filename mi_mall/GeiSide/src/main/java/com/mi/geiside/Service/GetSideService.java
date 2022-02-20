package com.mi.geiside.Service;

import com.mi.geiside.Domain.SideGoods;

import java.util.List;
import java.util.Map;

public interface GetSideService {
    Map<String, List<SideGoods>> getSide();
}
