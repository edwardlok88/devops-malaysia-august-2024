![image](https://github.com/user-attachments/assets/b697c7d4-1583-48b5-aefd-5754661c7039)# Day 2

## Lab - Cloning this training repository (one time activity)
```
cd ~
git clone https://github.com/tekutor/devops-malaysia-august-2024
cd devops-malaysia-august-2024
```

## Lab - Pulling delta changes from GitHub each time I push some changes
```
cd ~/devops-malaysia-august-2024
git pull
```

## Lab - Stopping your logstash service and manually running it

Check the config.conf under Day2/logstash
```
cd ~/devops-malaysia-august-2024
git pull
cd Day2/logstash
cat config.conf
cp config.conf /etc/logstash/conf.d
```

Now you procced with the below commands
```
sudo -i
systemctl stop logstash
systemctl disable logstash
cd /usr/share/logstash/bin
./logstash -f /etc/logstash/conf.d/config.conf
```

In a different terminal tab, you can check the logstash logs
```
tail -f /var/log/logstash/logstash-plain.log
```

Expected output
![image](https://github.com/user-attachments/assets/a845e423-c72b-4f06-903c-23633822dce0)


## Lab - Install Elasticsearch, Logstash and Kibana in Windows machine
You need to download elasticsearch, logstash and kibana for windows into your windows OS from below url
```
http://www.elastic.co/downloads
```

Download easticsearch for windows
![image](https://github.com/user-attachments/assets/aeb46bea-7248-48d8-a26e-3093f4f2a5bf)

Download logstash for windows
![image](https://github.com/user-attachments/assets/ee38a86a-ba58-4349-939b-85f818549550)


Download kibana for windows
![image](https://github.com/user-attachments/assets/52a6275e-7a60-4abf-a21e-258c1d41493c)
![image](https://github.com/user-attachments/assets/b5aed8d3-a1e5-4e84-94b9-0a724533c342)

Let's copy the download elasticsearch, logstash and kibana zip files from Downloads folder to C:\elk-stack
![image](https://github.com/user-attachments/assets/d78f5b7e-1beb-4e94-a11f-c20f3b7fd5be)
![image](https://github.com/user-attachments/assets/3c3f55e6-efbd-4130-b8f6-66749b6b9825)

Let's extract the elasticsearch zip from elk-stack folder as shown below
![image](https://github.com/user-attachments/assets/ab921a42-5c53-48d2-ad30-82e29ed49ef7)
![image](https://github.com/user-attachments/assets/6cc39585-9fd7-4085-a952-521052039148)

Let's extract the logstash zip from elk-stack folder as shown below
To troubleshoot long path error, you need to edit the registry in windows
HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\FileSystem->LongPathEnabled to 1 and restart the machine.
![image](https://github.com/user-attachments/assets/beefc015-ad06-4d06-807c-060fb1846074)

You could install 7zip tool to unzip to avoid troubles.

![image](https://github.com/user-attachments/assets/2cd92e2a-6dc5-4cca-bb0f-1a393b3b725b)
![image](https://github.com/user-attachments/assets/dfb159b0-1779-4e1e-ba4b-93c1b79694ee)
![image](https://github.com/user-attachments/assets/5bee4bd2-380c-466c-80f8-c56187302940)

Let's extract the kibana zip from elk-stack folder as shown below
![image](https://github.com/user-attachments/assets/8695ab0c-c01a-46e3-a54a-aedc94b1ef8e)

#### Launching elasticsearch nosql distributed database in windows as Administrator
```
cd C:\elk-stack\elasticsearch-8.14.3-windows-x86_64\elasticsearch-8.14.3\bin\elasticsearch.bat
```
![image](https://github.com/user-attachments/assets/a4e92277-27d8-47ed-93f6-613aa8bd2488)
![image](https://github.com/user-attachments/assets/ed36b4dd-dafa-40c7-8169-0e6b3af0a093)


Accessing the elastic search webconsole
<pre>
https://locahost:9200  
</pre>

![image](https://github.com/user-attachments/assets/5f3f7567-04c4-4cba-9423-b11292345031)

In case the user elastic was automatically created but you didn't note down the password, you may reset the password
```
cd C:\elk-stack\elasticsearch-8.14.3-windows-x86_64\elasticsearch-8.14.3\bin
elasticsearch-reset-password -u elastic
```
Expected output ( save this password in a file for your future use )
![image](https://github.com/user-attachments/assets/460a860d-e8ae-428c-a04b-a99fb8d64a42)

Once you have successfully logged in, you are supposed to see this message
![image](https://github.com/user-attachments/assets/14d4d035-c8f9-4a8f-8084-c2fc884680da)


#### Launching logstash in windows machine
You need to create a config.conf file and place it under C:\elk-stack\logstash-8.14.3\conf folder.
![image](https://github.com/user-attachments/assets/be6681fa-35cc-4be4-a04f-8d410e6d48f3)

Navigate to the below folder in windows explorer, copy the path, launch a command prompt as Administrator and navigate to the below path
```
cd C:\elk-stack\logstash-8.14.3\bin
```

Expected ouptut
![image](https://github.com/user-attachments/assets/64165454-048b-4123-b20e-f5ec783f4dad)
![image](https://github.com/user-attachments/assets/3abb2262-54ba-45cd-ac70-20a3058b8c4d)

#### Launching kibana dashboard in windows machine
You need to configure the kibana.conf under C:\elk-stack\kibana-8.14.3-windows-x86_64\kibana-8.14.3\config as shown below
![image](https://github.com/user-attachments/assets/2a4ae3bf-a1cc-4c2c-97fb-a3063b94c965)
![image](https://github.com/user-attachments/assets/6acec5b1-9397-4386-8db7-0b6f9677000b)

Now you may launch kibana as shown belo
```
kibana.bat
```

Expected output
![image](https://github.com/user-attachments/assets/4ff49275-2ae7-41f6-994c-c99c5e5ade47)

We need to reset the kibana_system user password in elasticsearch
```
elasticsearch-reset-password.bat -u kibana_system
```
![image](https://github.com/user-attachments/assets/7e22060b-377d-4111-adb5-bc486813bfe1)

We need to create a regular non-admin user in kibana.yml as shown
![image](https://github.com/user-attachments/assets/e67ec60c-0cdb-472c-92ae-081be6b290eb)

If everything is done correctly, you are expected to see the below 
![image](https://github.com/user-attachments/assets/59662fcc-db7c-4175-8919-7cf9e038eea5)
![image](https://github.com/user-attachments/assets/a5c7631b-9548-40fe-bbaa-6fe1b3b64ee2)
