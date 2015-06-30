<?php
	
	/*

		API SAMPLE CODE PHP

		API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/{classroomNumber}
		Function: retrieve information for an individual classroom {classroomNumber} of the form x-xxx

	*/



	//peform get request and store json response (String)
	$jsonResponseString = file_get_contents("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115");

	//parse json response string into JSON object
	$jsonObject		= json_decode($jsonResponseString, true);

	//retrieves data for classroom 1-115 as classroomData from within data field of JSON object
	$classroomData 	= $jsonObject['data'];

	
	//Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']'
	print "<h3>Capacity:</h3>";

	print $classroomData['capacity'];

	//Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]'
	print "<h3>URL of first picture:</h3>";

	print $classroomData['urls'][0];

?>