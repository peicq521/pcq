package com.fh.shop.backend.controller;

import com.fh.shop.backend.common.FileInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    /**
     * 获取根目录
     *
     * @param request
     * @return
     */
    protected String getRootPath(HttpServletRequest request) {

        String realPath = request.getServletContext().getRealPath("/");

        return realPath;
    }

    /**
     * 生成FileInfo
     *
     * @param multipartFile
     * @return
     */
    protected FileInfo createFileInfo(@RequestParam MultipartFile multipartFile) {

        //生成实体类
        FileInfo fileInfo = new FileInfo();

        if (null != multipartFile && multipartFile.getSize() > 0) {

            try {
                //输出流/用于文件的读写
                InputStream is = multipartFile.getInputStream();
                //文件名/获取文件后缀
                String fileName = multipartFile.getOriginalFilename();
                //文件输出流
                fileInfo.setInputStream(is);
                //文件名称
                fileInfo.setFileName(fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileInfo;
    }

    /**
     * createFileInfoList
     *
     * @param multipartFiles
     * @return
     */
    protected List<FileInfo> createFileInfoList(@RequestParam MultipartFile[] multipartFiles) {

        List<FileInfo> fileInfoList = new ArrayList<FileInfo>();

        if (null != multipartFiles && multipartFiles.length > 0) {

            for (MultipartFile childImage : multipartFiles) {

                FileInfo fileInfo = createFileInfo(childImage);

                if (StringUtils.isNotEmpty(fileInfo.getFileName())) {

                    fileInfoList.add(fileInfo);
                }
            }
        }
        return fileInfoList;
    }

    protected Map orderStyle(HttpServletRequest request) {

        String orderColumn = null;
        //判断是否为空
        if (request.getParameter("order[0][column]") != null) {
            //获取排序的列
            String order = request.getParameter("order[0][column]");
            //排序的字段
            orderColumn = request.getParameter("columns[" + order + "][data]");
        }
        String orderDir = null;
        //排序方式
        if (request.getParameter("order[0][dir]") != null) {

            orderDir = request.getParameter("order[0][dir]");
        }

        Map orderStyle = new HashMap();

        orderStyle.put("orderColumn", orderColumn);

        orderStyle.put("orderDir", orderDir);

        return orderStyle;
    }
}
