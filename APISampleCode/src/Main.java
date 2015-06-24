import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;



public class Main {
    public static void main(String[] args){
		// URL to call
    	String urlString = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115"; 
    	String urlStringAll = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms";
    	HttpURLConnection urlConnection;
    	StringBuffer response = new StringBuffer();
    	StringBuffer responseAll = new StringBuffer();
    	JSONObject jsonObject;
       
         
       try {   //this begins the first url
	    	   URL url = new URL(urlStringAll);
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           String inputLine;
	           
	           while ((inputLine = in.readLine()) != null) {
	        	   responseAll.append(inputLine);
	           }
	           
	           in.close();
	           
	           try {
	        	   jsonObject = new JSONObject(responseAll.toString());
	        	   System.out.println("JSON Object" + jsonObject);

	           } catch (JSONException e){
	          	   System.out.println("a JSON Exception occured" + e.toString());
	           }
	           //this ends the first url
	           
	           
	           
	           
	           //this begins the second url
	           url = new URL(urlString);
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           
	           while ((inputLine = in.readLine()) != null) {
	        	   response.append(inputLine);
	           }
	           
	           in.close();
	           
	           try {
	        	   jsonObject = new JSONObject(response.toString());
	        	   System.out.println("JSON Object" + jsonObject);
	        	   System.out.println("JSON Object --> building" + jsonObject.getJSONObject("data").getString("building"));
	           } catch (JSONException e){
	          	   System.out.println(e.toString());
	           }
	           //this ends the second url
	           
           
           } catch (Exception e) {
           System.out.println("I/O error occured" + e.toString());
       }    
      
	}
}
