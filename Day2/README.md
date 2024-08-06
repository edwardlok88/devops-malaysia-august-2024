# Day 2


## Lab - Stopping your logstash service and manually running it
```
sudo -i
systemctl stop logstash
cd /usr/share/logstash/bin
./logstash -f /etc/logstash/conf.d/config.conf
```

Expected output
