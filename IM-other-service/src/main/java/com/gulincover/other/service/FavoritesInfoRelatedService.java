package com.gulincover.other.service;

import com.gulincover.other.dao.FavoritesInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesInfoRelatedService {
    @Autowired
    private FavoritesInfoMapper favoritesInfoMapper;
}
