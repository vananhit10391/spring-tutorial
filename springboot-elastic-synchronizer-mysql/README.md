# springboot-elastic-synchronizer-mysql module
## Install
### Elastissearch
* Install and start Elastissearch at link:
    `https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started-install.html`
* Note: version elasticsearch = 7.10.0
### Kibana
* Install and start Kibana at link:
    `https://www.elastic.co/guide/en/kibana/current/install.html`
## Testing
* `curl -H "Content-Type: application/json" -XGET localhost:7005/search/user/`
* `curl -d '{"firstName": "Thomas","lastName": "Tom"}' -H "Content-Type: application/json" -XPOST localhost:7005/user/`
*  Waiting about 3 minutes
* `curl -H "Content-Type: application/json" -XGET localhost:7005/search/user/`
* `curl -d '{"id": "1", "firstName": "Thomas_temp","lastName": "Tom_temp"}' -H "Content-Type: application/json" -XPUT localhost:7005/user/`
*  Waiting about 3 minutes
* `curl -H "Content-Type: application/json" -XGET localhost:7005/search/user/`