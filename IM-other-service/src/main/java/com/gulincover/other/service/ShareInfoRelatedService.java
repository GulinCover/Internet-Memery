package com.gulincover.other.service;

import com.gulincover.other.dao.ShareInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareInfoRelatedService {
    @Autowired
    private ShareInfoMapper shareInfoMapper;
}
