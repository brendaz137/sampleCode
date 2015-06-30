<?php
	
	/*	
		API SAMPLE CODE

		URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}
		Function: retrieve record for {kerbid}
	*/

	//peform get request and store json response (String)
	$responseString = file_get_contents("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo");

	//parse json response string into JSON object
	$jsonObject = json_decode($responseString, true);

	//retrieve record from JSON object
	$record = $jsonObject['item'];

	print "<h3> RECORD FOR {KERBID}: </h3>";

	//parse JSON object back into String for printing and print
	print json_encode($record);

?>