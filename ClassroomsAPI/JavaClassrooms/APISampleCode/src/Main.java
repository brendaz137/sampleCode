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
 * API SAMPLE CODE JAVA
 * 
 * API URL 1: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/{classroomNumber}
 * API URL 2: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms
 * External Libraries: JSONObject and JSONArray from http://www.json.org/java/
 * 
 * {classroomNumber} should be of form x-xxx
 * 
 */


public class Main {
    public static void main(String[] args){
		// create variables for URLs
    	String urlString = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115"; 
    	String urlStringAll = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms";
    	// create HttpURLConnection object and other required resources
    	HttpURLConnection urlConnection;
    	StringBuffer response = new StringBuffer();
    	StringBuffer responseAll = new StringBuffer();
    	// create variable that will store returned JSON object
    	JSONObject jsonObject;
       
    	//this begins the first URL for all Classrooms
       try {   
    	   		//convert URL string into URL object
	    	   URL url = new URL(urlStringAll);
	    	   // perform GET request to the URL
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           // create buffered reader and string to read the response
	           BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           String inputLine;
	            
	           // read response and append to response string buffer
	           while ((inputLine = in.readLine()) != null) {
	        	   responseAll.append(inputLine);
	           }
	           
	           // done reading response so close buffered reader
	           in.close();
	           
	           try {
	        	   //convert response to a string and use to create JSON object
	        	   jsonObject = new JSONObject(responseAll.toString());
	        	   
	        	   // output first 5 classrooms in JSON format
	        	   System.out.println("FOR ALL CLASSROOMS:");
	        	   System.out.println("Display information for first 5 classrooms in JSON format: ");
	        	   for(int i = 0; i < 5; i++) {
	        		   System.out.println(jsonObject.getJSONArray("data").getJSONObject(i));
	        		}
	        	   //catch possible JSON Exceptions
	           } catch (JSONException e){
	          	   System.out.println("a JSON Exception occured" + e.toString());
	           }
	           
	           
	           
	           
	           //this begins the second url for an individual classroom
	           url = new URL(urlString);
	           urlConnection = (HttpURLConnection) url.openConnection();
	           
	           in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	           
	           while ((inputLine = in.readLine()) != null) {
	        	   response.append(inputLine);
	           }
	           
	           in.close();
	           
	           try {
	        	   //convert response to a string and use to create JSON object
	        	   jsonObject = new JSONObject(response.toString());
	        	   
	        	   //output selected data from classroom 1-115
	        	   System.out.println("FOR AN INDIVIDUAL CLASSROOM:");
	        	   System.out.println("Display capacity value of JSON Object (classroom 1-115):");
	        	   System.out.println(jsonObject.getJSONObject("data").getString("capacity"));
	        	   System.out.println("Display url of first picture of JSON Object:");
	        	   System.out.println(jsonObject.getJSONObject("data").getJSONArray("urls").getString(0));
	           //catch possible JSON Exceptions
	           } catch (JSONException e){
	          	   System.out.println(e.toString());
	           }
	           //this ends the second url
           
	       //catch possible input/output errors
           } catch (Exception e) {
           System.out.println("I/O error occured" + e.toString());
       }    
      
	}
}
