<?php
	
	/*

	API SAMPLE CODE PHP
	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/{classroomNumber}
	Function: retrieve information for an individual classroom {classroomNumber} of the form x-xxx

	*/



	//peform get request and store json response (String)
	$responseObject = file_get_contents("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115");
	//parse json response string into JSON object
	$jsonObject		= json_decode($responseObject, true);
	//retrieves data for classroom 1-115 as classroomData from within data field of JSON object
	$classroomData 	= $jsonObject['data'];

	
	//Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']'
	print "Capacity:" . $classroomData['capacity'];
	//Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]'
	print "URL of first picture:" . $classroomData['urls'][0];

?>