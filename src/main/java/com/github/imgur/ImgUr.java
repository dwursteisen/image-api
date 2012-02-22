package com.github.imgur;

import com.github.imgur.api.image.ImageManager;
import com.github.imgur.api.image.ImageResponse;
import com.github.imgur.api.stats.StatsManager;
import com.github.imgur.api.stats.StatsResponse;
import com.github.imgur.api.upload.UploadManager;
import com.github.imgur.api.upload.UploadResponse;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:11
 */
public class ImgUr {
    private final ImgUrRequestGenerator requestGenerator;

    public ImgUr(String apiKey) {
        requestGenerator = new ImgUrRequestGenerator(apiKey);
    }

    public UploadManager upload() {
        return new UploadManager(UploadResponse.class, requestGenerator);
    }

    public StatsManager stats() {
        return new StatsManager(StatsResponse.class, requestGenerator);
    }

    public ImageManager image() {
        return new ImageManager(ImageResponse.class, requestGenerator);
    }
}
