package com.feagle.learn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文件操作相关
 * Created by Feagle on 2017/7/1.
 */
public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void writeByFileReader(String path, String info) throws IOException {
        //获取文件的完整路径
        FileWriter fileWriter = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(info);

        } catch (Exception e) {
            logger.error("write file error {}", e);
            throw new IOException("write file error", e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (Exception e) {
                    logger.error("关闭BufferedWrite失败", e);
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (Exception e) {
                    logger.error("关闭OutputStreamWriter失败", e);
                }
            }
        }
    }
}
