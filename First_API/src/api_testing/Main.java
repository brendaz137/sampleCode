package api_testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	
	public static void main(String[] args){
		// URL to call
		String urlString = "http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115"; 
		HttpURLConnection urlConnection = null;
		        
		BufferedReader inputStream;
		StringBuffer response = new StringBuffer();
		        
		JSONObject jsonObject;
		JSONArray jsonArray;
		
		try{
			URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
   		 	String inputLine;
   		 	
   		 	while ((inputLine = in.readLine()) != null) {
   		 		response.append(inputLine);
   		 	}	//end while
   		 	
   		 	in.close();
   		 	
   		 try {
   			 jsonObject = new JSONObject(response.toString());
   			 System.out.println(jsonObject);
   			 } catch (JSONException e){
   				 System.out.println(e.toString());
               }//end catch
 		      
		} catch (Exception e){
			//if any I/O error occurs
			System.out.println(e.toString());
		}
		
	} 	//end public static void main  
}		//end public class Main