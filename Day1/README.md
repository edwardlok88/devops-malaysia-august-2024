![image](https://github.com/user-attachments/assets/8fac0d75-dd4e-4f45-8eae-70523ffb3f12)# Day 1

## Elastic Search Overview
<pre>
- Elastic Search is a distributed database
- it stores the logs in key/value format
- the values is generally stored as JSON(JavaScript Object Notation)
- supports creating a cluster of elastic search databases, i.e there can more than one elastic search nodes(servers)
- the more instances of elasticsearch databases instances/nodes we add more highly available(HA) it is
- more detailed documentation can be found from their official web page https://www.elastic.co/guide/en/elasticsearch/reference/current/elasticsearch-intro.html
</pre>

## Logstash Overview
<pre>
- Logstash converts the application logs into a format that can be stored inside the Elasticsearch database  
- an alternate to logstash is fluentd
</pre>

## Kibana Overview
<pre>
- Kibana is a visual dashboard for presenting the application logs as text or charts ( pie chart, bar charts, etc.,)
- helps you access the application logs from a centralized web console
</pre>

### ELK Stack
<pre>
E - stands for ElasticSearch database
L - stands for Logstash
K - Kibana
- is an opensource stack used for checking applications logs
- always used as a combination
- these 3 softwares are called in short as ELK stack
- in case if would like to change the Logstash with Fluentd then the stack is referreds as EFK
- letter F stands for Fluentd
- alternate to ELK is
  - EFK
  - splunk
</pre>


## Lab - Let's create an Azure Ubuntu Virtual Machine

#### Create a resource group in Azure portal
![image](https://github.com/user-attachments/assets/054b4932-efb2-4da7-b491-2a5f765bb54e)
Click "Create"
![image](https://github.com/user-attachments/assets/2b1b4d07-cf8d-41b3-aadc-39a448217756)
Click "Review + Create"
![image](https://github.com/user-attachments/assets/ca738c4c-6abe-43f7-a6a2-92193d2384df)
Click "Create"
![image](https://github.com/user-attachments/assets/c01a9649-3c11-467e-b30c-00365074ef31)
![image](https://github.com/user-attachments/assets/fc9776d5-4286-48a1-a894-557dcc8fcbe0)

From Azure portal Home Page, click on "Create a Resource"
![image](https://github.com/user-attachments/assets/68cd224f-e472-4313-a7c8-87a4e50c6404)
![image](https://github.com/user-attachments/assets/f908c282-8329-45a5-996a-ecceeb4d2487)
Select "Ubuntu Server 22.04 LTS"
![image](https://github.com/user-attachments/assets/e529ded2-631c-42e7-b15b-6c8ed3dab8d2)

![image](https://github.com/user-attachments/assets/1d824127-d52c-459a-9b39-728a27fc42fa)
![image](https://github.com/user-attachments/assets/3eaa1512-fc7a-43b3-a631-58a9315cfb4c)
![image](https://github.com/user-attachments/assets/9186c9bb-4c6b-4ba4-a00d-fb77546b0281)
![image](https://github.com/user-attachments/assets/74432e77-831c-4d7d-9798-8fed92a3ff5c)

Click "Review + Create"
![image](https://github.com/user-attachments/assets/c3608f86-2cd1-44e1-a74f-5050f9dc5aca)
Click "Create"
![image](https://github.com/user-attachments/assets/1c0bd4f5-91a2-4a55-b51c-9f6f240384e7)
Click "Download private key and create resource"
![image](https://github.com/user-attachments/assets/a5d5f6e7-25c5-4734-9469-c5470692ecc2)
![image](https://github.com/user-attachments/assets/46252b3d-fa32-4703-a8aa-316c63ad920b)
![image](https://github.com/user-attachments/assets/c999754b-1714-4fe5-8b9e-4da4beac93fd)

Click "Go to resource" and see the VM details
![image](https://github.com/user-attachments/assets/3cc7f118-4166-401f-984e-5e0bc1b55b0e)

Let's SSH into the Azure ubuntu virtual machine
```
cd ~/Downloads
ls -l ubuntu-azure-vm_key.pem
ssh -i  ubuntu-azure-vm_key.pem jegan@172.206.62.162
```
![image](https://github.com/user-attachments/assets/974a1350-1390-4ef1-abcd-67bbb2b39ccd)

The private key must be protected by giving read permission only to current user, hence let's change the permission
```
chmod 400 ubuntu-azure-vm_key.pem
ls -l ubuntu-azure-vm_key.pem
```

## Lab - Installing Elastic Search database in Azure Ubuntu 22.04 Virtual Machine
```
curl -fsSL https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo gpg --dearmor -o /usr/share/keyrings/elastic.gpg

echo "deb [signed-by=/usr/share/keyrings/elastic.gpg] https://artifacts.elastic.co/packages/7.x/apt stable main" | sudo tee -a /etc/apt/sources.list.d/elastic-7.x.list

sudo apt update
sudo apt install elasticsearch
```

Expected output
![image](https://github.com/user-attachments/assets/f2c2ad15-ad22-4007-9053-34644495c110)
![image](https://github.com/user-attachments/assets/0a12478e-e9e2-4bec-9f7a-59752275e3e7)


We need to configure elastic search
```
sudo vim /etc/elasticsearch/elasticsearch.yml
```
After editing the file /etc/elasticsearch/elasticsearch.yml content should appear as shown below
<pre>
bootstrap.memory_lock: false
cluster.name: tektutor-elasticsearch 
path.data: /var/lib/elasticsearch
path.logs: /var/log/elasticsearch
node.name: node-1

http.port: 9200
node.data: true
node.ingest: true
node.master: true
node.max_local_storage_nodes: 1
cluster.initial_master_nodes: node-1
transport.tcp.port: 9300
xpack.license.self_generated.type: basic
xpack.security.enabled: false
network.host: ["0.0.0.0", 127.0.0.1", "[::1]"]
network.bind_host: 0.0.0.0
network.publish_host: 0.0.0.0
http.host: 0.0.0.0
http.cors.enabled : true
http.cors.allow-origin : "*"
http.cors.allow-methods : OPTIONS, HEAD, GET, POST, PUT, DELETE
http.cors.allow-headers : X-Requested-With,X-Auth-Token,Content-Type, Content-Length
</pre>

We need to start the elastic search
```
sudo systemctl enable elasticsearch
sudo systemctl start elasticsearch
sudo systemctl status elasticsearch
sudo apt install -y net-tools
sudo ufw allow 9200
sudo ufw enable
sudo ufw status

curl -X GET 'http://localhost:9200/_nodes?pretty'
```

Expected output
![image](https://github.com/user-attachments/assets/57878ba3-a378-432c-b262-b7978577b21e)
![image](https://github.com/user-attachments/assets/389e4523-8d06-4b0d-941f-1e71ea678d52)
![image](https://github.com/user-attachments/assets/438dddb9-0126-44aa-8d6b-d085e3708f87)
![image](https://github.com/user-attachments/assets/9c7a6a79-ea59-443b-b5af-9a762efb418e)
![image](https://github.com/user-attachments/assets/e5c42d4e-f4ad-4868-94ec-552b24bbf6c9)
![image](https://github.com/user-attachments/assets/a36afe1a-c8c5-48bb-bd46-e0446245228f)
![image](https://github.com/user-attachments/assets/9c8e154d-f3a1-4c70-ad0c-e4bf480f9c0e)

#### Let's test using elasticsearch
```
curl -X PUT -H "Content-Type: application/json"  'localhost:9200/tutorial/helloworld/1?pretty' -d '
{
  "message": "Hello Malaysia! - Elastic Search"
}'
```

#### Let's test retrieving from elasticsearch
```
curl -X GET -H "Content-Type: application/json" 'http://localhost:9200/tutorial/helloworld/1'
```

Expected output
![image](https://github.com/user-attachments/assets/3d24a65b-44c1-4746-8928-b6fcee1f09c1)

### Let's try posting some message onto the remote elastic search server from our local machine
You need to replace the azure virtual machine IP in the place of 20.244.89.122.
```
curl -X PUT -H "Content-Type: application/json"  '20.244.89.122:9200/tektutor/message/1?pretty' -d '
{
  "message": "Hello, Malaysia !!!"
}'
```

Expected output
![image](https://github.com/user-attachments/assets/0d5197d6-d7f2-43a0-9b65-53fb75ab504f)


### Let's try retrieving the messages we inserted into the elastic search from our local machine
```
curl -X GET -H "Content-Type: application/json"  '20.244.89.122:9200/tektutor/message/1?pretty'
```

Expected output
![image](https://github.com/user-attachments/assets/788f0973-10b5-495b-aad4-8de6842fb960)

## Lab - Installing logstash into Azure virtual machine
```
sudo apt-get  install -y logstash
```
Expected output
![image](https://github.com/user-attachments/assets/116c1708-a465-4828-8f46-6eb5f6dedb9e)
![image](https://github.com/user-attachments/assets/5cc7cc89-dd1d-4786-9416-6747db639372)


You need to create a configuration file /etc/logstash/conf.d/config.yml with the below content
<pre>
input {
  beats {
    port => 5044
  }
}

output {
  elasticsearch {
    hosts => ["http://localhost:9200"]
    index => "%{[@metadata][beat]}-%{[@metadata][version]}" 
  }
}
</pre>

Your save file should look as shown below
```
cat /etc/logstash/conf.d/config.yml
```

Expected output  


Let's start the logstash sevice
```
sudo systemctl enable logstash
sudo systemctl start logstash
sudo systemctl status logstash
```

Expected output
![image](https://github.com/user-attachments/assets/4ce438c6-c215-4401-9267-c871aa1ae6c7)

## Elasticsearch beats
<pre>
- there are many elastic search beat utilities that can feed logs to logstash
- logstash takes these inputs, filters and converts the data fed by beat utilities to a format that is supported by Elasticsearch
- the below are the possible beat utilities you could use
  - Filebeat
  - Packetbeat
  - Heartbeat
  - Winlogbeat
  - Metricbeat
  - Auditbeat
- you could explore about the various beat utilities here https://www.objectrocket.com/resource/what-are-elasticsearch-beats/
</pre>

Let's use Filebeat, which is good enough to take application logs from any folder and feed the same to logstash.

Let's install filebeat
```
sudo apt-get install filebeat
```
Expected output


We need to configure the filebeat to feed the application logs to logstash as opposed to directly feeding the logs to elasticsearch. Hence, we need to configure the /etc/filebeat/filebeat.yml
```
sudo vim /etc/filebeat/filebeat.yml
```
Disable elasticsearch output by commenting as shown below 
![image](https://github.com/user-attachments/assets/b4c52b5e-5e75-42a7-80a1-4a04c3dc4626)

Enable the logstash output by uncommenting as shown below
![image](https://github.com/user-attachments/assets/a04f66d6-d85b-43d8-8bcd-caa09bc39781)

Filebeat support many input sources
```
sudo filebeat modules list
```

Out of the above modules, we are only interested in system module that helps in picking the application logs from a system folder and feed it to logstash
```
sudo filebeat modules enable system
sudo filebeat setup --pipelines --modules system
```

Expected output
![image](https://github.com/user-attachments/assets/fcec8b4f-f764-4a65-ab29-1c2e56c9153a)
![image](https://github.com/user-attachments/assets/d11aa743-02f1-4886-a58b-c6ea97e72cca)

Load the index template to elasticsearch 
```
sudo filebeat setup --index-management -E output.logstash.enabled=false -E output.elasticsearch.hosts=["localhost:9200"] -E setup.kibana.host=localhost:5601
```

Expected output
![image](https://github.com/user-attachments/assets/b6c6273c-15fe-4bae-92e5-ec6976b5deb0)


Let's start the filebeat
```
sudo systemctl enable filebeat
sudo systemctl daemon-reload
sudo systemctl start filebeat
sudo systemctl status filebeat
```

Let's test the filebeat
```
curl -XGET 'http://localhost:9200/filebeat-*/_search?pretty'
```

Expected output
![image](https://github.com/user-attachments/assets/76cc5c7b-e3ed-411b-8d9e-23f74057ba26)

