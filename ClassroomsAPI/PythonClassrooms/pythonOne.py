'''
	API SAMPLE CODE PYTHON
	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/{classroomNumber}
	Function: retrieve information for an individual classroom {classroomNumber} of the form x-xxx
	Libraries: json and urllib2
'''

import urllib2
import json

#preform get request and store response to get information for classroom 1-115
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115").read()

#retrieves data for classroom 1-115 as classroomData from within data field
classroomData = json.loads(responseObject)['data']

#Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']'
print "Capacity:" + classroomData['capacity']

#Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]':
print "URL of first picture:" + classroomData['urls'][0]
