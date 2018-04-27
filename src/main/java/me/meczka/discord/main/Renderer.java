package me.meczka.discord.main;

import me.meczka.discord.net.RequestSender;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk on 27.04.2018.
 */
public class Renderer {
    public static int getIdFromName(String name)
    {
        String body = "[\""+name+"\"]";
        CloseableHttpResponse response = RequestSender.sendPost(null,body,"https://esi.tech.ccp.is/v1/universe/ids/");
       try {
           String responseString =  EntityUtils.toString(response.getEntity(), "UTF-8");
           JSONObject jsonObject = new JSONObject(responseString);
           int  id  = jsonObject.getJSONArray("inventory_types").getJSONObject(0).getInt("id");
           return id;
       }catch(IOException e){e.printStackTrace();}
       return -1;
    }
    public static JSONObject getTypeAttributesFromID(int id)
    {
        List<String> pathParams = new ArrayList<>();
        pathParams.add(Integer.toString(id));
        CloseableHttpResponse response = RequestSender.sendGet("https://esi.tech.ccp.is/v3/universe/types/",pathParams);
        try {
            String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(responseString);
            JSONObject jsonObject = new JSONObject(responseString);
            return jsonObject;
        }catch(IOException e){e.printStackTrace();}

    return null;
    }
}
