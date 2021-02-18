package com.gulincover.home.service.otherRelated;

import com.gulincover.home.dao.BrowseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseInfoRelatedService {
    @Autowired
    private BrowseInfoMapper browseInfoMapper;
}
