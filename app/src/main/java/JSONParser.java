/**
 * Created by 翔翔 on 2018-01-07.
 */
package com.hxf.currencies;
import android.util.Log;
import org.apache.http.*;
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

        }
    }
}
