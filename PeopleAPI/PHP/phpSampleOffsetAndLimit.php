<?php
	
	/*
		API SAMPLE CODE

		API URL: http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10

		Function: retrieve first 10 records (by alphabetical order) with an offset of 1
	*/

	//peform get request and store json response (String)
	$responseString = file_get_contents("http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10");

	//parse json response string into JSON object
	$jsonObject = json_decode($responseString, true);

	//retrieve records from JSON object
	$records = $jsonObject['items'];

	print "<h3>FIRST 10 RECORDS WITH OFFSET OF 1:</h3>";

	//parse JSON OJBECT back into String for printing
	print json_encode($records);

?>