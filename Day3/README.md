# Day 3

## Lab - Installing ELK stack in Windows 11 Pro 64-bit VM on Azure cloud
#### Launch Elastic search
![image](https://github.com/user-attachments/assets/4365bb19-93c2-4496-9a78-368d8acbd984)
![image](https://github.com/user-attachments/assets/f45f3427-153b-4502-b348-03027ccf8396)
![image](https://github.com/user-attachments/assets/f25e4eba-59e8-446f-9bb3-7255031c4195)
![image](https://github.com/user-attachments/assets/84becbdc-aa2a-42a3-9bd3-217341cae8e4)

#### Launch Kibana and connect with Elasticsearch cluster
![image](https://github.com/user-attachments/assets/866bdc08-2cfe-4751-8507-09288ba06aee)
![image](https://github.com/user-attachments/assets/1dcaef2a-0408-47a3-9454-918c337245c3)
![image](https://github.com/user-attachments/assets/912b1e07-fa69-4138-8a20-1154993f9b4c)
![image](https://github.com/user-attachments/assets/5ed40b68-5dd5-42e9-802f-65e1813cdffb)
![image](https://github.com/user-attachments/assets/9137972e-3a83-4121-a392-651b6da3d7a5)

![image](https://github.com/user-attachments/assets/4b53c85c-fa4c-4c17-a44e-dea25a596660)
![image](https://github.com/user-attachments/assets/f10f85d9-ca23-416d-a0d2-050ae62adb24)
![image](https://github.com/user-attachments/assets/55e772d1-f8b4-46ed-a933-766894ff0190)
![image](https://github.com/user-attachments/assets/fd0af8f8-7558-4499-a526-73b4c0805531)
![image](https://github.com/user-attachments/assets/a964561f-29cf-41a6-b39e-6db97672df23)

[image](https://github.com/user-attachments/assets/24e6484a-db61-4392-b1d8-33eed4aa7e39)
[image](https://github.com/user-attachments/assets/d95b31d5-be87-4fc4-935d-2a0b29bd7e60)

[image](https://github.com/user-attachments/assets/76530417-b07c-47ca-9531-dccb7d16a8c7)
![image](https://github.com/user-attachments/assets/f7385f6c-df86-4a77-b260-5d11126763b0)
![image](https://github.com/user-attachments/assets/92c0d751-fe29-4b33-be60-35b0cdd5e6ba)
![image](https://github.com/user-attachments/assets/19396b21-0c58-4df8-9499-07f19f78aae7)

#### Configure logstash and launch from windows command prompt as Administrator
![image](https://github.com/user-attachments/assets/c6179dfc-a289-487e-af5a-f85f6597f589)

![image](https://github.com/user-attachments/assets/4323905a-ff1b-4f17-a453-fe6b59bfeecf)

## Lab - Collecting performance metrics using Prometheus and visualizing metrics using Grafana Dashboard

Deploying Proemetheus as a Docker container
```
docker run -d --name prometheus --hostname prometheus bitnami/prometheus:latest
docker ps
docker logs prometheus
```

Find the IP Address of your prometheus container
```
docker inspect prometheus | grep IPA
```
Expected output
![image](https://github.com/user-attachments/assets/835682a7-e2a0-463d-bd83-81176bae4e42)


You can access the prometheus dashboard, in the below url you need to use the IP address of your prometheus container
<pre>
http://172.17.0.2:9090  
</pre>

Expected output
![image](https://github.com/user-attachments/assets/df80f7cc-43ed-4024-b21c-c61e9a3a32bb)

Deploying grafana as a Docker container
```
docker ps
docker run -d --name grafana --hostname grafana bitnami/grafana:latest
docker ps
docker logs grafana
```

Expected output
![image](https://github.com/user-attachments/assets/de718f29-cc09-464a-9ae8-a24481033a18)

Find the IP address of grafana container
```
docker inspect -f {{.NetworkSettings.IPAddress}} grafana
```

Accessing the grafana dashboard from your web browser
```
http://172.17.0.3:3000
```
Default grafana login credentials
<pre>
username - admin
password - admin
</pre>

Expected output
![image](https://github.com/user-attachments/assets/0486fcc4-aab3-4d94-93de-193b600f0b3d)
![image](https://github.com/user-attachments/assets/5d141d12-f44e-48d3-b709-2e3b4ed42d50)
![image](https://github.com/user-attachments/assets/832f3117-cb59-4ac3-b3e6-cb72be18f465)

Change the grafana password to "Admin@123"
![image](https://github.com/user-attachments/assets/53b64a96-3d89-4772-8c50-f2e1f02d261b)
![image](https://github.com/user-attachments/assets/a39f7836-3e42-435b-8257-699b1e6c99c1)


Currently, prometheus is collecting performance metrics from only Prometheus. You may navigate to Status => Target
![image](https://github.com/user-attachments/assets/2a404118-710a-45f7-8068-bb274cc45467)

You can access the prometheus metrics at url http://172.17.0.2:9090/metrics
![image](https://github.com/user-attachments/assets/b64c4670-8605-411f-885c-d6c393843afa)

Integrating Prometheus with Grafana
![image](https://github.com/user-attachments/assets/2eeda054-bee0-45a2-9332-e9d5b3c24e79)

Add Datasource
![image](https://github.com/user-attachments/assets/c098b4d8-638a-4dcb-90fa-d62964de4be0)
Select Prometheus
![image](https://github.com/user-attachments/assets/d168b20b-d764-4e76-8708-219f81666ee6)
![image](https://github.com/user-attachments/assets/198bb162-76d6-401f-8e8a-5e9c9f2ccff6)
![image](https://github.com/user-attachments/assets/bb96cea9-9d55-4add-a3eb-0cf2eef651b7)
Click Save & Test
![image](https://github.com/user-attachments/assets/1f2468da-998d-491e-a726-89c6908a56df)

Click on Dashboards
![image](https://github.com/user-attachments/assets/3711d7f3-65c2-4ca8-9ce6-4bad6ff9d544)
Click on New to see the import option
![image](https://github.com/user-attachments/assets/12ac50d6-0ad5-4822-b13d-136b3c0d3af0)
Click on import
![image](https://github.com/user-attachments/assets/b33a565a-bdf3-4a76-8bd6-d53c6c757933)
Type "9964"
![image](https://github.com/user-attachments/assets/983cd2e2-22b2-4af9-8947-6f404ef28f36)
Click "Load"
![image](https://github.com/user-attachments/assets/6876cc0a-8175-4117-805d-7dd64ac976f0)
Click "Import" and select "prometheus" datasource
![image](https://github.com/user-attachments/assets/a542860e-37cf-4757-b0a4-0864bcd8225b)
![image](https://github.com/user-attachments/assets/c74ac9f4-2844-4b58-a11e-71b9bc56e92e)

Let's download jenkins.war from jenkins.io/download url
![image](https://github.com/user-attachments/assets/86c7b1df-991d-47f5-a565-af9c0bc7f690)

We need to download Generic Java Package on the left side (LTS)
![image](https://github.com/user-attachments/assets/fc841344-e502-44e0-abf0-2bce72e3da37)
![image](https://github.com/user-attachments/assets/c4efdcc8-d986-4930-9f21-853c75c51638)

You can launch jenkins from terminal as shown below
```
cd ~/Downloads
java -jar ./jenkins.war
```

Expected output
![image](https://github.com/user-attachments/assets/0485aa4f-37b1-422f-a860-774b98ede6d5)
![image](https://github.com/user-attachments/assets/fa082004-14b6-44e2-b9b7-6a533a90d67d)
![image](https://github.com/user-attachments/assets/6d5bec55-cedd-4b30-815c-4c5bd17d13d9)

From your web browser, you may access Jenkins dashboard as shown below
```
http://localhost:8080
```

Expected output
![image](https://github.com/user-attachments/assets/0901a956-f890-4aa4-a71e-8bcf80290c32)
Let's copy the initial admin password from web browser as shown below
![image](https://github.com/user-attachments/assets/53383580-788f-4fec-a3e8-902058ca348a)
![image](https://github.com/user-attachments/assets/692c1c4d-7ed4-4333-a5df-d6ce4168999b)
