package com.example.c09_project_book.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dpbhulkak",
                    "api_key", "862323418758771",
                    "api_secret", "dKp8c2uRX9-55OI1H1IGFQ4XtT4"
            ));
        }
        return cloudinary;
    }
}
