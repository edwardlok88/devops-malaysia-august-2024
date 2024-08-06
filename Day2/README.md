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
