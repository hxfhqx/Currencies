/**
 * Created by 翔翔 on 2018-01-07.
 */
package com.hxf.currencies;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;

public class JSONParser {
    static InputStream inputStream = null;
    static JSONObject sReturnJsonObject = null;
    static String sRawJsonString ="";

    public JSONParser(){}
    public JSONObject getJSONFromUrl(String url){
        // attempt to get response from server
        try{
            DefaultHttpCLient httpCLient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(url);
            HttpResponse httpResponse=httpCLient.execute(httpPost);
            HttpEntity htttpEntity=httpResponse.getEntity();
            sInputStream=httpEntity.getContent();
        }   catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }   catch (ClientProtocolException e){
            e.printStackTrace();
        }   catch (IOException e){
            e.printStackTrace();
        }
        // read stream into string-builder
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(sInputStream,"iso-8859-1"),8);
            StringBuilder stringBuilder=new StringBuilder();
            String line=null;
            while ((line=reader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            sInputStream.close();
            sRawJsonString =stringBuilder.toString();
        }   catch (Exception e){
            Log.e("Error reading from Buffer:"+e.toString(),this.getClass().getSimpleName());
        }
        try{
            sReturnJsonObject =new JSONObject(sRawJsonString);
        }   catch (JSONException e){
            Log.e("Parser","Error when parsing data"+e.toString());
        }
        // return Json object
        return sReturnJsonObject;
    }
}
