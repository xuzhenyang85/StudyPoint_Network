# HTTP-Exercises

### 1) Monitoring HTTP Headers 1

Ændret index.html til index1.html efter opgavens krav

Jeg kan kigge på Console, hvis der er noget javascript på siden, på den måde kan jeg f.eks. finde fejler. 


Jeg kan kikke på Network, og reload siden får jeg en list af hvad jeg får response fra serveren. 
PT. får jeg `Status 404 Not Found` i Network, når siden er kørt `http://localhost:8084/Exercises_HTTP/`. 

Siden har type som er dokument, derudover kan det også være script, stylesheet, jpg eller png. 

Size 1,2 KB fortæller størrelsen på den side, Time er 39 ms, det fortæller den tid for request og response på den side. 

Content-text var engelsk.

Hvis jeg går ind på index1.html, får jeg `Status Code 200 OK` i Network. Time er 62 ms. Size 449 B. Content-text er skiftet til dansk.

### 2) Monitoring HTTP Headers 2
Status Code:304 Not Modified
Connection:keep-alive: Den fortæller at forbindelsen står persistent 

### 3) Monitoring HTTP Headers 3
URL: `https://studypoints.dk/#/view1`


### 5) 
Method = get , får hidden value i url
Method = post, får hidden value i http pakker navn

## Session and Cookies

### 6) 
Session gemmer kun mens jeg bruger browseren.

7) 
Cookies gemmer fysisk i vores pc.


## Exercise Network Exam Preparation

### Network interfaces, IP-numbers and more
1. What is the ip address of your wireless card?
Ip adresse på wireless kort: 192.168.0.19

2. What is special about the IP-addresses that starts with 10 (and 172.16 and 192.168)
- ip-adresse starter med 10 er 24 bit block, og kan rumme 16777216 antal ip adresser
- ip-adresse starter med 172 er 20 bit block, og kan rumme 1048576 antal ip adresser
- ip-adresse starter med 192 er 16 bit block, og kan kun rumme 65536 antal ip adresser

3. Who or what gave you that address? 
DHCP 

4. What is a DHCP server (conceptually)
DHCP er en del af Transmission Control Protocol/Internet Protocol (TCP/IP) protokolsuiten og sørger for at administrere og tildele IP-adresser til forskellige computere i et TCP/IP netværk.

5. What is the address of your DHCP Server
Adresse af DHCP Server: 10.255.1.9

6. What is a DNS server (conceptually)
DNS: Domain Name System(Domain Name Server, Domain Name Service). En DNS-server eller navneserver er en server placeret på et IP-baseret datanet, der tager sig af oversættelsen af de navne man normalt arbejder med på Internettet.

7. What is the DNS server address?
DNS adresse: 193.162.153.164 el 194.239.134.83

8. What is a MAC address
Mac adressen er enhendens unikke identikikatior tildelt til netværksgrænsefladen.

9. What is the MAC address of the your Network Interface(s)?
MAC adresser ac:bc:32:d2:9c:47 

10. How many network interfaces do you have?
Mere end 1, local adresse (LAN)

11. Why do you have more than one? What are they for?


12. What is your public address (WAN) (can’t be found with ipconfig)  address right now. Ask others in the class for theirs, do you all have the same public address ?
www.whatismyip.com

## Networking

1. Find the IP address for cphbusiness.dk
195.254.168.52

2. When was cphbusiness.dk registered first time and whois the Registrant
2008-12-15 - Knord S/I

3. Use ping to verify whether you Digitalocean Droplet is online
yes, ping 46.101.109.188

4. How many routers do you need to go through to reach dr.dk?
Terminal: traceroute dr.dk
12 router

5. How many routers do you need to go through to reach rhcloud.com?
Terminal: traceroute rhcloud.com
8 router

6. How many active connections do you have on your computer?
Terminal: lsof -i  eller netstat
7 connections. Mange

7. What is the round-trip time to reach google.com?
30.977 ms med ping.

8. Why is it so low if Google is in the United States?
Google har en kompleks server.

9. Start your local Tomcat server and use netstat to verify whether “anyone” is listening on port 8080 and 3306 (what would you expect to find listening on 3306?)
Tjek port 8080: lsof -n -i:8080 | grep LISTEN
Tjek port 3360: lsof -n -i:3306 | grep LISTEN

10. If you have setup MySQL on Digital Ocean to be accessible from the school (or home), verify this using Telnet. If not, ask around in the class, and find one who has.
telnet 46.101.109.188 3306, connected...


## Domain Name System

1. Find the IP address for your domain name (won’t work, unless you have completed the steps below)
Terminal: nslookup xudk.me
Domain navn: xudk.me
Ip adresse: 46.101.109.188

2. Set up your HostName to point to your droplet(s) as explained here in the steps:
Configuring your Domain Part-1,  Change your Domain Server,  Configuring your Domain Part-2

Digitalocean: Networking - add a domain
Namecheep: tilføjer nameservers


3. Wait some time (why) perhaps an hour, and repeat step 2.


4. Verify that your droplet(s) can be using your domain name
https://xudk.me/ og http://46.101.109.188/ 
Det virker



