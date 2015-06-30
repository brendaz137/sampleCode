<?php
	/*

	API SAMPLE CODE PHP
	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms
	Function: retrieve information for all MIT classrooms 
	
	*/

	//peform get request and store json response (String)
	$jsonResponseString = file_get_contents("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms");

	//parse json response string into JSON object
	$jsonObject	= json_decode($jsonResponseString, true);

	//retrieves data for all classrooms as allClassroomData from within data field of JSON object
	$allClassroomData = $jsonObject['data'];

	//Display information for first 5 classrooms by slicing 'allClassroomData' and convert it into JSON format: </font>";
	$allClassroomDataDisp = json_encode(array_slice($allClassroomData, 0, 5) );

	print "<h3>Data for first 5 classrooms:</h3>";

	print $allClassroomDataDisp;

?>