#!/bin/bash
sudo python3 ./web/web.py
cp ./web/page.txt ./out/production/script/
sudo java ./out/production/script/Script.class
Echo "success!"