package com.jyong.java.http;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
/**
 * @Author jyong
 * @Date 2024/3/23 21:35
 * @desc
 */

public class HttpFileUpload {

    public static void main(String[] args) throws Exception{
        String url="/Users/jyong/Downloads/desktop.ini";
//        uploadFile(new File(url));

        String test = HttpUtil.createPost(UPLOAD_URL)
                .form("test", url)
                .execute().body();
        System.out.println(test);

//        getRequest();
    }

    private static void getRequest(){
        String s = HttpUtil.get("http://localhost:8080/somnambulist/launcher/app.run");
        System.out.println(s);
    }

    private static final String UPLOAD_URL = "http://localhost:8080/somnambulist/launcher/upload";

    public static void uploadFile(File fileToUpload) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(UPLOAD_URL);

            // 创建FileBody对象
            FileBody fileContent = new FileBody(fileToUpload);

            // 构建multipart/form-data实体
            HttpEntity multipart = MultipartEntityBuilder.create()
                    .setContentType(ContentType.MULTIPART_FORM_DATA)
                    .addPart("file", fileContent) // 添加文件部分
                    .build();

            httpPost.setEntity(multipart);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

                // 获取响应内容
                String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");

                System.out.println(responseString);
                // 处理响应内容
                // ...在此处添加您自己的逻辑来处理响应结果
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }
}
