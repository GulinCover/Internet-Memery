package com.gulincover.other.controller.fileRelated;

import com.google.common.base.Charsets;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpReq.fileReq.PostFileInfoReq;
import com.gulincover.other.service.FileInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Api("InquireFileInfoApi")
@RestController
public class InquireFileInfoApi {

    @Autowired
    private FileInfoRelatedService fileInfoRelatedService;

    /*
    api
     */
    @ApiOperation("/api/file/picture/{fileName}")
    @GetMapping(value = "/api/file/picture/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void inquirePictureFileApi(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        CompletableFuture<byte[]> bytes = fileInfoRelatedService.inquirePictureFileByFileInfoByPictureName(fileName, HttpStateCode.NOT_FOUND);

        try {
            response.getWriter().write(Arrays.toString(bytes.get()));
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("/api/post/file")
    @PostMapping(value = "/api/post/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void inquireNonPictureFileApi(PostFileInfoReq fileInfoReq, HttpServletResponse response) {
        try {
            Integer ret = fileInfoRelatedService.inquirePictureFileByFileInfoByFileName(fileInfoReq, response.getOutputStream());
            if (0 == ret) {
                String s = "attachment;filename=" + fileInfoReq.getFileName();
                response.setHeader(HttpHeaders.CONTENT_DISPOSITION, s);
                response.setCharacterEncoding("UTF-8");
            } else {
                response.getWriter().write(HttpStateCode.NOT_FOUND.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    rpc
     */

    /*
    test
     */
}
