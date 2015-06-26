import urllib2
import json


'''
	URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}
	Function: retrieve record for {kerbid}

'''

#peform get request and store response (as a String)
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo").read()

#parse json response string into JSON object
record = json.loads(responseObject)['item']

print
print
print "RECORD FOR {KERBID}:"
print
print
print record
print
print

'''
	URL: http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10
	Function: retrieve first 10 records (by alphabetical order) with an offset of 1

'''

#peform get request and store response (as a String)
responseObject = urllib2.urlopen("http://mit-public-dev.cloudhub.io/people/v2/people?offset=1&limit=10").read()

#parse json response string into JSON object
records = json.loads(responseObject)

print "FIRST 10 RECORDS WITH OFFSET OF 1:"
print
print
print records
print
print