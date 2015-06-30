import urllib2
import json


#accesses information for all classrooms
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms").read()

#retrieves data for all classrooms as allClassroomData
allClassroomData = json.loads(responseObject)['data']

print "FOR ALL CLASSROOMS:"
print
print "Display information for first 5 classrooms using 'allClassroomData[0:5]':"
print
print allClassroomData[0:5]
print
print



#accesses information for classroom 1-115
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/classrooms/v1/classrooms/1-115").read()

#retrieves data for classroom 1-115 as classroomData
classroomData = json.loads(responseObject)['data']

print "FOR AN INDIVIDUAL CLASSROOM:"
print
print "Display JSON Object containing data for classroom 1-115 using 'classroomData':"
print
print classroomData
print
print
print "Display capacity value of JSON Object (classroom 1-115) using 'classroomData['capacity']':"
print
print classroomData['capacity']
print
print
print "Display url of first picture of JSON Object (classroom 1-115) using 'classroomData['urls'][0]':"
print
print classroomData['urls'][0]
