package com.comlu.navinsandroidtutorial.srm_billingappjsonwebservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import javax.net.ssl.HttpsURLConnection;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    private static final String DEBUG_TAG = "HttpExample";

    // constructor
    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String urlAddress) {

        // Making HTTP request
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;
        URL url;
        String response = "";
        try {
            url = new URL(urlAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15001);
            conn.setConnectTimeout(15001);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            int reqresponseCode = conn.getResponseCode();

            if (reqresponseCode == HttpsURLConnection.HTTP_OK) {
                StringBuilder sb = new StringBuilder();
                String line = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                response=sb.toString();
            } else {
                response = "";
            }
            try {

                jObj = new JSONObject(response);
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

        }



         catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (ProtocolException e1) {
            e1.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }



        return jObj;
    } 


    }
