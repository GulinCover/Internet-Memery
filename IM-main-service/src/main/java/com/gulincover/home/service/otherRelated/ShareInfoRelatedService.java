package com.gulincover.home.service.otherRelated;

import com.gulincover.home.dao.ShareInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareInfoRelatedService {
    @Autowired
    private ShareInfoMapper shareInfoMapper;
}
