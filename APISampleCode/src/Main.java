import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

//this is a comment
//this is a second comment

//this is a fourth comment

public class Main {
    public static void main(String[] args){
		// URL to call
    	String urlString = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms"; 
    	HttpURLConnection urlConnection;
    	StringBuffer response = new StringBuffer();
    	JSONObject jsonObject;
       
         
       try {
    	   URL url = new URL(urlString);
           urlConnection = (HttpURLConnection) url.openConnection();
           
           BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
           String inputLine;
           
           while ((inputLine = in.readLine()) != null) {
        	   response.append(inputLine);
           }
           
           in.close();
           
           try {
        	   jsonObject = new JSONObject(response.toString());
        	   //System.out.println(jsonObject);
        	   //System.out.println(jsonObject.getString("data"));
        	   System.out.println(jsonObject.getJSONObject("data"));
        	   } 
           catch (JSONException e){
          	   System.out.println(e.toString());
          	   }
           } 
       
       catch (Exception e) {
           // if any I/O error occurs
           System.out.println(e.toString());
       }    
	}
}
