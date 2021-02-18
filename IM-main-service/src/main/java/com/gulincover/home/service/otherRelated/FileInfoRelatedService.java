package com.gulincover.home.service.otherRelated;

import com.gulincover.home.dao.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileInfoRelatedService {
    @Autowired
    private FileInfoMapper fileInfoMapper;
}
