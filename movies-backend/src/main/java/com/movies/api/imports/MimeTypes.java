package com.movies.api.imports;

import org.springframework.web.multipart.MultipartFile;

public class MimeTypes {

    private static final String MIME_TEXT_CSV = "text/csv";
    private static final String MIME_APPLICATION_MS_EXCEL = "application/vnd.ms-excel";

    public static boolean isCsvMultipartFile(final MultipartFile multipartFile) {
        return MIME_TEXT_CSV.equalsIgnoreCase(multipartFile.getContentType()) ||
                MIME_APPLICATION_MS_EXCEL.equalsIgnoreCase(multipartFile.getContentType());
    }
}
