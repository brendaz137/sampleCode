
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


/**
 * 
 * @author kb-squared
 *
 * API sample code for People API
 * 
 * API URL 1: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid} 
 * API URL 2: http://mit-public-dev.cloudhub.io/people/v2/people?offset={n}&limit={n}
 *
 * External Libraries: JSONObject and JSONArray from http://www.json.org/java/
 * 
 */
public class Main {
    public static void main(String[] args){
		// URLs
    	String urlStringKerbId = "http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo"; 
    	String urlStringOffsetAndLimit = "http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10";
    	
    	// create HttpURLConnection object and other required resources
    	HttpURLConnection urlConnection;
    	StringBuffer responseStringBuffer = new StringBuffer();
    	
    	// create variable that will store returned JSON object
    	JSONObject jsonObject;
       
         
       try {   
    	   	   // convert URL string into URL object
	    	   URL url = new URL(urlStringKerbId);
	    	   
	    	   // perform GET request to the URL
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           // create buffered reader and string to read the response
	           BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           String inputLine;
	           
	           // read response and append to string buffer
	           while ((inputLine = in.readLine()) != null) {
	        	   responseStringBuffer.append(inputLine);
	           }
	           
	           // done reading response so close buffered reader
	           in.close();
	           
	           try {
	        	   // convert string buffer to string
	        	   String responseString = responseStringBuffer.toString();
	        	   
	        	   // use response string to create JSON object
	        	   jsonObject = new JSONObject(responseString);
	        	   
	        	   // retrieve record object from response object
	        	   JSONObject record = jsonObject.getJSONObject("item");
	        	   
	        	   // print output to console
	        	   System.out.println("RECORD FOR {KERBID}: ");
	        	   System.out.println();
	        	   System.out.println(record);
	        	   System.out.println();
	           } catch (JSONException e){
	          	   System.out.println(e.toString());
	           }
	           
	           // convert URL string into URL object
	    	   url = new URL(urlStringOffsetAndLimit);
	    	   
	    	   // perform GET request to the URL
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           // create buffered reader and string to read the response
	           in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           
	           // create new string buffer
	           responseStringBuffer = new StringBuffer();
	           
	           // read response and append to string buffer
	           while ((inputLine = in.readLine()) != null) {
	        	   responseStringBuffer.append(inputLine);
	           }
	           
	           // done reading response so close buffered reader
	           in.close();
	           
	           try {
	        	   // convert string buffer to string
	        	   String responseString = responseStringBuffer.toString();
	        	   
	        	   // use response string to create JSON object
	        	   jsonObject = new JSONObject(responseString);
	        	   	        	   
	        	   // retrieve records array from response object
	        	   JSONArray records = (JSONArray) jsonObject.getJSONArray("items");
	        	   
	        	   // print output to console
	        	   System.out.println("FIRST 10 RECORDS WITH OFFSET OF 1 ");
	        	   System.out.println();
	        	   System.out.println(records);
	        	   System.out.println();
	           } catch (JSONException e){
	          	   System.out.println(e.toString());
	           }
           } catch (Exception e) {
        	   // show error in console
        	   System.out.println(e.toString());
       }    
	}
}
