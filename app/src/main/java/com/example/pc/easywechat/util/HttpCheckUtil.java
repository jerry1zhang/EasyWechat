package com.example.pc.easywechat.util;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HttpCheckUtil {
	/**
	 * 获取远程服务器ATN结果
	 * 
	 * @param urlvalue
	 *            指定URL路径地址
	 * @return 服务器ATN结果
	 * @throws IOException 
	 */
	public static String checkUrl(String urlvalue){
		String inputLine = "";
		try {
		URL url = new URL(urlvalue);
		URLConnection urlConnection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		inputLine = in.readLine().toString();
		}catch (Exception e) {  
        	e.printStackTrace();
        }
		return inputLine;
	}
	
	public static String sendPost(String url,  HashMap<String,String> param , String paramjiami) {
		String inputLine = "";
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer paramval = new StringBuffer();
		Date a = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String FKEY = MD5.MD5Encode(paramjiami+"jerry"+dateFormat.format(new Date()));
		paramval.append("FKEY=").append(FKEY);
		Set<String> keyset = param.keySet();
		Iterator<String> inerator = keyset.iterator();
		String next = "";
		while (inerator.hasNext()){
			next = inerator.next();
			paramval.append("&");
			paramval.append(next).append("=").append(param.get(next));
		}
        try {  
        	HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection(); 
    		urlConnection.setDoOutput(true);  
    		urlConnection.setDoInput(true);   
    		out = new PrintWriter(urlConnection.getOutputStream());  
//            out.print(param);  
            out.print(paramval.toString());
            out.flush();  
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
    		return inputLine;
        } catch (Exception e) {
			Log.e("Exception",e.toString());
            e.printStackTrace();  
        }  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return null;  
    }

}
