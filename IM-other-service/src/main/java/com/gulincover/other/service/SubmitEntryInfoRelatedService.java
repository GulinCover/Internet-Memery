package com.gulincover.other.service;

import com.gulincover.other.dao.SubmitEntryInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmitEntryInfoRelatedService {
    @Autowired
    private SubmitEntryInfoMapper submitEntryInfoMapper;
}
