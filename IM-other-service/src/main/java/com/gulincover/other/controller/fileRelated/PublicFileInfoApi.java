package com.gulincover.other.controller.fileRelated;

import com.gulincover.api.HttpStateCode;
import com.gulincover.other.service.FileInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.nio.file.Files;

@Api("PublicFileInfoApi")
@RestController
public class PublicFileInfoApi {
    @Autowired
    private FileInfoRelatedService fileInfoRelatedService;

    @ApiOperation("/api/post/submit/file")
    @PostMapping("/api/post/submit/file")
    public String publicFileInfo(CommonsMultipartFile c) {

        return HttpStateCode.OK.toString();
    }
}
