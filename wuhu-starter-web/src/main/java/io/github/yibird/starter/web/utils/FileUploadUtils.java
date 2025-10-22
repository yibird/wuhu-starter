package io.github.yibird.starter.web.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.URLUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @Description 文件上传工具类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:13
 */
public class FileUploadUtils {

    /**
     * 上传文件
     *
     * @param file                  文件对象
     * @param filePath              上传文件存储路径
     * @param isUseOriginalFilename 是否使用原文件名做为文件,不使用这会随机生成文件名
     * @return 返回上传成功的File对象
     * @throws IOException IO异常
     */
    public static File uploadFile(MultipartFile file, String filePath, boolean isUseOriginalFilename) throws IOException {

        // 获取文件原始名称
        String originalFilename = file.getOriginalFilename();
        // 获取文件扩展名
        String extensionName = FileNameUtil.extName(originalFilename);
        // 文件名
        String fileName;
        if (isUseOriginalFilename) {
            String date = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATETIME_MS_PATTERN);
            fileName = "%s-%s.%s".formatted(FileNameUtil.getPrefix(originalFilename), date, extensionName);
        } else {
            fileName = "%s.%s".formatted(IdUtil.fastSimpleUUID(), extensionName);
        }
        try {
            String pathname = filePath + fileName;
            File dest = new File(pathname).getCanonicalFile();
            // 文件写入
            file.transferTo(dest);
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载
     *
     * @param response 响应对象
     * @param file     文件
     */
    public static void download(HttpServletResponse response, File file) throws IOException {
        download(response, new FileInputStream(file), file.getName());
    }

    /**
     * 下载
     *
     * @param response    响应对象
     * @param inputStream 文件流
     * @param fileName    文件名
     * @since 2.5.0
     */
    public static void download(HttpServletResponse response,
                                InputStream inputStream,
                                String fileName) throws IOException {
        byte[] bytes = IoUtil.readBytes(inputStream);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setContentLength(bytes.length);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLUtil.encode(fileName));
        IoUtil.write(response.getOutputStream(), true, bytes);
    }
}
