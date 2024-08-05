# Day 1

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
sudo ufw allow from 198.168.1.0 to any port 9200
sudo ufw enable
sudo ufw status

curl -X GET 'http://localhost:9200/_nodes?pretty'
```

Expected output
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
```
curl -X PUT -H "Content-Type: application/json"  '20.244.89.122:9200/tektutor/message/1?pretty' -d '
{
  "message": "Hello, Malaysia !!!"
}'
```

Expected output
![image](https://github.com/user-attachments/assets/0d5197d6-d7f2-43a0-9b65-53fb75ab504f)
