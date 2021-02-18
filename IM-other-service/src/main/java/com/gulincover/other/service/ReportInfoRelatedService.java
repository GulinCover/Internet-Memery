package com.gulincover.other.service;

import com.gulincover.other.dao.ReportInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportInfoRelatedService {
    @Autowired
    private ReportInfoMapper reportInfoMapper;
}
