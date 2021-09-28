# Spring Cloud Streams example

This project uses:
- spring boot 2 (2.5.5) 
- spring-cloud 2020.0.3
- java 11

There are 3 projects:

- a sender  (creates messages, as a producer)
- a producer (transform messages, as a transformer)
- a logger (consume messages as a consumer)

The names of the projects are from spring page. soo 

```
                                                          +------- publish to usage-cost.logger
                                                          |                                  |
                                                          |                                  |
usage-detail-sender-rabbit             usage-cost-processor-rabbit                      usage-cost-logger
    |                                        |
    |                                        | this is the input for the transformer
    |                                        |
    +----------- publish to usage-detail.usage-cost-consumer

```


## Useful commands:

- build: 
```
./build.sh
```

- Start applications: (First you have to build the apps)
```
docker-compose up --build [-d] 
```
Use `-d` if you want to detach. The log will not be printed to console

- Stop the applications 
```
docker-compose down
```

