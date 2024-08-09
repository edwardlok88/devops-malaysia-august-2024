# Day 5

## Lab - Running a simple employee microservice that supports CRUD operations
```
cd ~/devops-malaysia-aug-2024
git pull
cd Day4/employee
mvn clean package
cd target
ls
java -jar ./employee-ms-1.0.jar
```

Expected output
![image](https://github.com/user-attachments/assets/788447c3-6fd2-4af6-a1da-fede20e8fc16)
![image](https://github.com/user-attachments/assets/e195d261-ed38-4dbd-89c6-087becda93dc)
![image](https://github.com/user-attachments/assets/aa962e88-d415-4d03-a040-987d2610025f)

Running the test application that uses RestTemplate to invoke the above REST API
```
cd ~/devops-malaysia-aug-2024
git pull
cd Day4/
mvn test
```

Expeted output
![image](https://github.com/user-attachments/assets/0b39d396-cdc1-49b1-be55-28a2532563dc)
![image](https://github.com/user-attachments/assets/43184065-d1fb-4ffe-95ea-f02b78abdf32)



