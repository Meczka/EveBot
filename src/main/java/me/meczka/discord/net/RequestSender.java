package me.meczka.discord.net;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Patryk on 27.04.2018.
 */
public class RequestSender {
    public static CloseableHttpResponse sendPost(Map<String,String> queryParams, String body , String uri)
    {
        CloseableHttpClient client = HttpClients.createDefault();
        if(queryParams!=null)
        {
            uri += "?";
            for(Map.Entry<String,String> entry : queryParams.entrySet())
            {
                uri+=entry.getKey()+"="+entry.getValue()+"&";
            }

        }
        HttpPost httpPost = new HttpPost(uri);
        try {
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = client.execute(httpPost);
            return response;
        }
        catch(UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public static CloseableHttpResponse sendGet(String uri,List<String> pathParams)
    {
        CloseableHttpClient client = HttpClients.createDefault();
        if(pathParams!= null)
        {
            Iterator i = pathParams.iterator();
            while(i.hasNext())
            {
                uri+=i.next()+"/";
            }
        }
        HttpGet httpGet = new HttpGet(uri);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            return response;
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
