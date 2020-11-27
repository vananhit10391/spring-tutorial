# springboot-elasticsearch module
## Install
### Elastissearch
* Install and start Elastissearch at link:
    `https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started-install.html`
* Note: version elasticsearch = 7.10.0
### Kibana
* Install and start Kibana at link:
    `https://www.elastic.co/guide/en/kibana/current/install.html`
* Access Kibana dev_tools and create "location_map" index
    `PUT /location_map`
## Testing
* `curl -H "Content-Type: application/json" -XGET localhost:7002/profile/`
* `curl -H "Content-Type: application/json" -XGET localhost:7002/profile/{id}`
* `curl -d '{"firstName":"John","lastName":"Doe","technologies":[{"name":"tech 01","yearsOfExperience":"1 year"},{"name":"tech 02","yearsOfExperience":"2 years"}],"location":{"lat":"Da Nang","lon":"Viet Nam"},"emails":["JohnDoe01@email.com","JohnDoe02@email.com"]}' -H "Content-Type: application/json" -XPOST localhost:7002/profile/`
* `curl -H "Content-Type: application/json" -XPOST "localhost:7002/profile/" --data-binary "@ProfileDocument.json"`