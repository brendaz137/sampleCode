'''
	API SAMPLE CODE PYTHON

	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/{classroomNumber}
	Function: retrieve information for an individual classroom {classroomNumber} of the form x-xxx
	Libraries: json and urllib2
'''

import urllib2
import json

#perform get request and store json response (String) to get information for classroom 1-115
jsonResponseString = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115").read()

#parse json response string into JSON object
jsonObject = json.loads(jsonResponseString)

#retrieve classroom data from JSON object
classroomData = jsonObject['data']

print

#Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']'
print "CAPACITY:" + classroomData['capacity']

print

#Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]':
print "URL OF FIRST PICTURE:" + classroomData['urls'][0]

print