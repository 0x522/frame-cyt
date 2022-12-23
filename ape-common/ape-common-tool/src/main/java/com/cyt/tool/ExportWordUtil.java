package com.cyt.tool;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 导出Word工具
 */
public class ExportWordUtil {
    private static final String SUFFIX = ".doc";

    private static Configuration configuration = null;

    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(ExportWordUtil.class, "/template/word");
    }

    public static void exportWord(Map map, String title, String ftlName) throws Exception {
        Template template = configuration.getTemplate(ftlName);
        File file;
        InputStream inputStream;
        ServletOutputStream out = null;

        //创建doc文件
        file = createDocFile(map, template);

        inputStream = new FileInputStream(file);

        String fileName = title + SUFFIX;

        HttpServletResponse response = SpringContextUtils.getHttpServletResponse();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/msword");
        //附件
        response.setHeader("Content-Disposition", "attachment:filename=" + URLEncoder.encode(fileName));
        out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesToRead = -1;
        while ((bytesToRead = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, bytesToRead);
        }

        if (out != null) {
            out.close();
        }
        inputStream.close();
        file.delete();
    }

    private static File createDocFile(Map dataMap, Template template) throws Exception {
        File file = new File("init.doc");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
        //渲染
        template.process(dataMap, writer);
        writer.close();
        return file;
    }
}
