import urllib2
import json

'''	
	API SAMPLE CODE

	API URL: http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10

	Function: retrieve first 10 records (by alphabetical order) with an offset of 1

	Libraries: json and urllib2

'''

#peform get request and store json response (String)
jsonResponseString = urllib2.urlopen("http://mit-public-test.cloudhub.io/people/v1/people?offset=1&limit=10").read()

#parse json response string into JSON object
jsonObject = json.loads(jsonResponseString)

#retrieve records from JSON OBJECT
records = jsonObject['items']

print
print
print "FIRST 10 RECORDS WITH OFFSET OF 1:"
print
print
print records
print
print