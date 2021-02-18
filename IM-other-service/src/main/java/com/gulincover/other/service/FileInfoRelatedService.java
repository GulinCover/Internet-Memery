package com.gulincover.other.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Charsets;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.FileInfo;
import com.gulincover.api.httpReq.fileReq.PostFileInfoReq;
import com.gulincover.other.dao.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class FileInfoRelatedService {
    @Autowired
    private FileInfoMapper fileInfoMapper;

    //访问图片数据
    @Async
    public CompletableFuture<byte[]> inquirePictureFileByFileInfoByPictureName(String accessPath, HttpStateCode httpStateCode) {
        QueryWrapper<FileInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("file_type", "png", "gif", "jpeg");
        queryWrapper.ge("access_path", accessPath);

        FileInfo fileInfo = fileInfoMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(fileInfo)) return CompletableFuture.completedFuture(httpStateCode.toString().getBytes(Charsets.UTF_8));

        File file = new File(fileInfo.getPhysicPath());
        if (!file.exists()) return CompletableFuture.completedFuture(httpStateCode.toString().getBytes(Charsets.UTF_8));

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return CompletableFuture.completedFuture(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return CompletableFuture.completedFuture(httpStateCode.toString().getBytes(Charsets.UTF_8));
    }

    public Integer inquirePictureFileByFileInfoByFileName(PostFileInfoReq fileInfoReq, OutputStream os) throws IOException {
        QueryWrapper<FileInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("access_path", fileInfoReq.getAccessPath());
        queryWrapper.eq("file_name", fileInfoReq.getFileName());
        queryWrapper.eq("user_id", fileInfoReq.getUserId());

        FileInfo fileInfo = fileInfoMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(fileInfo)) return -1;

        File file = new File(fileInfo.getPhysicPath());
        if (!file.exists()) return -1;

        BufferedOutputStream bos = new BufferedOutputStream(os);
        BufferedInputStream bis = null;
        byte[] buffer = new byte[4096];
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while (-1 != (i = bis.read(buffer))) {
                bos.write(buffer, 0, i);
                bos.flush();
            }
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bis != null;
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
