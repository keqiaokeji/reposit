package com.keqiaokeji.tezizai.common.file;

/**
 * @author: Ivan Vigoss
 * Date: 14-2-20
 * Time: PM3:19
 */
public class Uploader {

    private  String fileBasePath;

    private String imageBasePath;

    private String imageSmallPath;


    public String getFileBasePath() {
        return fileBasePath;
    }

    public void setFileBasePath(String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }

    public String getImageBasePath() {
        return imageBasePath;
    }

    public void setImageBasePath(String imageBasePath) {
        this.imageBasePath = imageBasePath;
    }

    public String getImageSmallPath() {
        return imageSmallPath;
    }

    public void setImageSmallPath(String imageSmallPath) {
        this.imageSmallPath = imageSmallPath;
    }
}
