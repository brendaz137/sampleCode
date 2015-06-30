'''
	API SAMPLE CODE PYTHON
	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms
	Function: retrieve information for all MIT classrooms
	Libraries: json and urllib2
'''

import urllib2
import json

#preform get request and store json response (String) to get information for all classrooms
jsonResponseString = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms").read()

#parse json response string into JSON object
jsonObject = json.loads(jsonResponseString)

#retrieves data for all classrooms as allClassroomData from json object
allClassroomData = jsonObject['data']

print 

#Display information for first 5 classrooms using 'allClassroomData[0:5]':
print "Data for first 5 classrooms" + str(allClassroomData[0:5])

print