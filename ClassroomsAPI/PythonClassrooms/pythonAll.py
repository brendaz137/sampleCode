'''
	API SAMPLE CODE PYTHON
	API URL: http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms
	Function: retrieve information for all MIT classrooms
	Libraries: json and urllib2
'''

import urllib2
import json

#preform get request and store response to get information for all classrooms
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms").read()

#retrieves data for all classrooms as allClassroomData from within data field
allClassroomData = json.loads(responseObject)['data']

#Display information for first 5 classrooms using 'allClassroomData[0:5]':
print "Data for first 5 classrooms" + allClassroomData[0:5]