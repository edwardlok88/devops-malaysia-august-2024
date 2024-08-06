# Day 2


## Lab - Stopping your logstash service and manually running it
```
sudo -i
systemctl stop logstash
cd /usr/share/logstash/bin
./logstash -f /etc/logstash/conf.d/config.conf
```

In a differnt terminal tab, you can check the logstash logs
```
tail -f /var/log/logstash/logstash-plain.log
```

Expected output
