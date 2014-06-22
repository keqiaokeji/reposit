package com.keqiaokeji.tezizai.common.file;

/**
 * Created by shk on 14-6-21.
 */
public class FileInfo {

    private String fileId;

    private String fileName;

    private FileType fileType;

    private String filePath;

    private String fileUrl;

    private Long fileLength;

    public static enum FileType {
        FILE_BASE,//原文件
        IMG_BASE,//原图
        IMG_SMALL;//小图
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }
}
