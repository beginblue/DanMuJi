package com.hiczp.danmuji.rest;

import com.hiczp.danmuji.Config;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czp on 16-8-20.
 * Message REST API
 */
public class Msg {
    public static String getData(String roomId) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(Config.msgUrl);

        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("roomid", roomId));

        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formParams, Config.charset);
            httpPost.setEntity(urlEncodedFormEntity);

            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            return EntityUtils.toString(httpEntity, Config.charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
