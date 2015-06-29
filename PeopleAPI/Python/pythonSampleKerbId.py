import urllib2
import json


'''
	API SAMPLE CODE

	API URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}

	Function: retrieve record for {kerbid}

	Libraries: json and urllib2

'''

#peform get request and store json response (String)
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo").read()

#parse json response string into JSON object
jsonObject = json.loads(responseObject);

#retrieve record from JSON object
record = jsonObject['item'];

print
print
print "RECORD FOR {KERBID}:"
print
print
print record
print
print

