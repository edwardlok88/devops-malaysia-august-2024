# Day 2

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
