LogMonster
==========
WORK IN PROGRESS
===========

Logging Client / Server experiment with alerting built directly into the server

Idea sparked by this blog piece http://java.dzone.com/articles/21st-century-logging.

Log events have always had structure, the speed we can write simply structured items to NoSQL DB's now means that we can write our events to a DB and maintin some of that structure. Making it easier to process later. Current systems allow you to add structure, but the programmer API is still based on strings.

We have written systems to parse log files and look for unusual events, but often it not the unusal events that are important ... its the lack of common events i.e. If nobody has logged into my busy site for the last 5 minutes ... something is wrong. Think of complex event processing a la drools fusion for processing log events (or lack of) and raising alerts from that

Runtime configuration is hard, many servers ... want to dynamically change the configuration, need a central location to manage this.

