package com.gt.inside.api.util.excel;

import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 获取模板文件的工具类
 * Created by psr on 2017/11/6 0006.
 */
public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/" + tempName));
        return fileInputStream;
    }

}
