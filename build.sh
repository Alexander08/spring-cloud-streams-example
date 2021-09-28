#!/usr/bin/env bash

cd usage-detail-sender-rabbit && mvn clean install
cd ../usage-cost-processor-rabbit && mvn clean install
cd ../usage-cost-logger-rabbit && mvn clean install

cd ..
