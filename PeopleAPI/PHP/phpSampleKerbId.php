<?php
	
	/*	
		API SAMPLE CODE

		URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}
		Function: retrieve record for {kerbid}
	*/

	//peform get request and store json response (String)
	$jsonResponseString = file_get_contents("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo");

	var_export($http_response_header, true);

	$responseCode = $http_response_header[0];

	print "<h3> RESPONSE CODE: </h3> "; 

	print $responseCode;

	//parse json response string into JSON object
	$jsonObject = json_decode($jsonResponseString, true);

	//retrieve record from JSON object
	$record = $jsonObject['item'];

	print "<h3> RECORD FOR {KERBID}: </h3>";

	//parse JSON object back into String for printing and print
	print json_encode($jsonObject);

?>