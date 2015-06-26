<?php
	
	/*
		URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}
		Function: retrieve record for {kerbid}
	*/

	//peform get request and store response
	$responseObject = file_get_contents("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo");

	//parse json response string into JSON object
	$jsonObject = json_decode($responseObject, true);

	//retrieve data from JSON object
	$record = $jsonObject['item'];

	print "<h3> RECORD FOR {KERBID}: </h3>";
	print json_encode($record);

	// Space between outputs
	print ("<br />\r\n");

	/*
		URL: http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10
		Function: retrieve first 10 records (by alphabetical order) with an offset of 1
	*/

	//peform get request and store response
	$responseObject = file_get_contents("http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10");

	//parse json response string into JSON object
	$jsonObject = json_decode($responseObject, true);

	print "<h3>FIRST 10 RECORDS WITH OFFSET OF 1:</h3>";
	print json_encode($jsonObject);

?>