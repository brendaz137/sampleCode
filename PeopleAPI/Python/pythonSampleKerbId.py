import urllib2
import json


'''
	API SAMPLE CODE

	API URL: http://mit-public-dev.cloudhub.io/people/v1/people/{kerbid}

	Function: retrieve record for {kerbid}

	Libraries: json and urllib2

'''

########################################################################################


'''

	API CALL WITH VALID KERBID

'''

#peform get request and store response
response = urllib2.urlopen("http://mit-public-dev.cloudhub.io/people/v1/people/kkatongo")

#get response code
responseCode = response.getcode()

#retrieve json (String) from response
jsonResponseString = response.read()


#parse json response string into JSON object
jsonObject = json.loads(jsonResponseString)

#retrieve record from JSON object
record = jsonObject['item']

print
print "## VALID API CALL"
print
print "RESPONSE CODE: " + str(responseCode)
print
print "RECORD FOR {KERBID}: " + str(record) 
print
print


'''

	API CALL WITH INVALID KERBID

'''

# try to peform get request and store response
try: 
	response = urllib2.urlopen("http://mit-public-dev.cloudhub.io/people/v1/people/puzzleduck")

#catch HTTPError	
except urllib2.HTTPError as errorResponse:

	#get response code
	responseCode = errorResponse.getcode()

	#retrieve json (String) from response
	jsonResponseString = errorResponse.read()

	#parse json response string into JSON object
	jsonObject = json.loads(jsonResponseString)

	print
	print "## INVALID API CALL"
	print
	print "RESPONSE CODE: " + str(responseCode)
	print
	print "RESPONSE: " + str(jsonObject)
	print
	print
