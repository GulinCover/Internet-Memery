package com.gulincover.home.service.otherRelated;

import com.gulincover.home.dao.FavoritesInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesInfoRelatedService {
    @Autowired
    private FavoritesInfoMapper favoritesInfoMapper;
}
