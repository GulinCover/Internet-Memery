package com.gulincover.other.service;

import com.gulincover.other.dao.LikeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeInfoRelatedService {
    @Autowired
    private LikeInfoMapper likeInfoMapper;
}
