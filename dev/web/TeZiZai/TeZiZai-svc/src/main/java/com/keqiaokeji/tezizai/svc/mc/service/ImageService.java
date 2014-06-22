package com.keqiaokeji.tezizai.svc.mc.service;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.file.FileInfo;
import com.keqiaokeji.tezizai.common.file.ImageCutUtils;
import com.keqiaokeji.tezizai.common.file.Uploader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by shk on 14-6-21.
 */
@Service("imageService")
public class ImageService {

    @Autowired
    private Uploader uploader;

    @Autowired
    private ImageCutUtils imageCutUtils;

    Logger logger = Logger.getLogger(ImageService.class.getName());
    String imageType = "png";

    public FileInfo uploadImage(MultipartFile file) throws Exception {
        String imageId = StringUtils.getUUID();
        return uploadImage(imageId, file);
    }

    public FileInfo uploadImage(String imageId, MultipartFile file) throws Exception {
        FileInfo fileInfo = new FileInfo();
        File targetFile = new File(uploader.getImageBasePath(), getImageName(imageId));
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        fileInfo.setFileId(imageId);
        fileInfo.setFileName(getImageName(imageId));
        fileInfo.setFileType(FileInfo.FileType.IMG_BASE);
        fileInfo.setFilePath(targetFile.getAbsolutePath());
        fileInfo.setFileLength(targetFile.length());
        imageCutUtils.compressWithCut(targetFile.getAbsolutePath(), getImagePath(imageId, FileInfo.FileType.IMG_SMALL), imageType, 80, 120);
        return fileInfo;
    }

    public FileInfo getImage(String fileId, FileInfo.FileType fileType) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFilePath(getImagePath(fileId, fileType));
        return fileInfo;
    }

    private String getImageName(String imageId) {
        return imageId + "." + imageType;
    }

    public String getImagePath(String imageId, FileInfo.FileType fileType) {
        if (fileType == FileInfo.FileType.IMG_BASE) {
            return uploader.getImageBasePath() + getImageName(imageId);
        } else if (fileType == FileInfo.FileType.IMG_SMALL) {
            return uploader.getImageSmallPath() + getImageName(imageId);
        }
        return null;
    }


}
