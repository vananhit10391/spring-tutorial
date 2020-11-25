# springboot-data-elasticsearch module
## Install
### Elastissearch
* Install and start Elastissearch at link:
    `https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started-install.html`
### Kibana
* Install and start Kibana at link:
    `https://www.elastic.co/guide/en/kibana/current/install.html`
## Testing
* `curl -H "Content-Type: application/json" -XGET localhost:7003/person/`
* `curl -d '{"firstName":"John","lastName":"Doe"}' -H "Content-Type: application/json" -XPOST localhost:7003/person/`