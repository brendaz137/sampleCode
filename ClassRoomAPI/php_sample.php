<?php

	//accessess information for all classrooms
	$responseObject = file_get_contents("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms");
	$jsonObject		= json_decode($responseObject, true);

	//retrieves data for all classrooms as allClassroomData
	$allClassroomData = $jsonObject['data'];

	print "<font color = 'red'> FOR ALL CLASSROOMS: </font>";
	print ("<br />\r\n");
	print "<font color = 'red'> Display information for first 5 classrooms by slicing 'allClassroomData' and convert it into JSON format: </font>";
	print ("<br />\r\n");
	$allClassroomDataDisp = json_encode( array_slice($allClassroomData, 0, 5) );
	print $allClassroomDataDisp;
	print ("<br />\r\n");
	print ("<br />\r\n");
	print ("<br />\r\n");
	print ("<br />\r\n");

	//accesses information for classroom 1-115
	$responseObject = file_get_contents("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115");
	$jsonObject		= json_decode($responseObject, true);
	
	//retrieves data for classroom 1-115 as classroomData
	$classroomData 	= $jsonObject['data'];

	print "<font color = 'red'> FOR AN INDIVIDUAL CLASSROOM: </font>";
	print ("<br />\r\n");
	print "<font color = 'red'> Display JSON Object containing data for classroom 1-115 by converting 'classroomData' into JSON format: </font>";
	print ("<br />\r\n");
	$classroomDataDisp 	= json_encode($classroomData, JSON_PRETTY_PRINT);
	print $classroomDataDisp;
	print ("<br />\r\n");
	print ("<br />\r\n");
	print "<font color = 'red'> Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']': </font>";
	print ("<br />\r\n");
	print $classroomData['capacity'];
	print ("<br />\r\n");
	print ("<br />\r\n");
	print "<font color = 'red'> Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]': </font>";
	print ("<br />\r\n");
	print $classroomData['urls'][0];

?>