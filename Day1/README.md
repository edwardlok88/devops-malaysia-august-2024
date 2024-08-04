# Day 1

## Lab - Installing Elastic Search Database in Azure Ubuntu 22.04 Virtual Machine
```
curl -fsSL https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo gpg --dearmor -o /usr/share/keyrings/elastic.gpg

echo "deb [signed-by=/usr/share/keyrings/elastic.gpg] https://artifacts.elastic.co/packages/7.x/apt stable main" | sudo tee -a /etc/apt/sources.list.d/elastic-7.x.list

sudo apt update
sudo apt install elasticsearch
```

We need to configure elastic search
```
sudo vim /etc/elasticsearch/elasticsearch.yml
```
The elasticsearch.yml shall be edited as shown below
<pre>
# ---------------------------------- Network -----------------------------------
#
# Set the bind address to a specific IP (IPv4 or IPv6):
#
network.host: localhost
</pre>

We need to start the elastic search
```
sudo systemctl enable elasticsearch
sudo systemctl start elasticsearch
sudo ufw allow from 198.51.100.0 to any port 9200
sudo ufw enable
sudo ufw status

curl -X GET 'http://localhost:9200/_nodes?pretty'
```

Expected output
<pre>
Output
{
  "name" : "elastic-22",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "DEKKt_95QL6HLaqS9OkPdQ",
  "version" : {
    "number" : "7.17.1",
    "build_flavor" : "default",
    "build_type" : "deb",
    "build_hash" : "e5acb99f822233d62d6444ce45a4543dc1c8059a",
    "build_date" : "2022-02-23T22:20:54.153567231Z",
    "build_snapshot" : false,
    "lucene_version" : "8.11.1",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}  
</pre>

Using elasticsearch
```
curl -XPOST -H "Content-Type: application/json" 'http://localhost:9200/tutorial/helloworld/1' -d '{ "message": "Hello World!" }'
```

Retrieving from elasticsearch
```
curl -X GET -H "Content-Type: application/json" 'http://localhost:9200/tutorial/helloworld/1'
```
