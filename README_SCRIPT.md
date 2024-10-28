## setup SSH key github
```bash
ssh_keygen -t rsa -b 4096 -C "email.com"
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
cat ~/.ssh/id_rsa.pub
```

```aiignore
sudo -u postgres psql
GRANT USAGE ON SCHEMA public TO hades;
GRANT CREATE ON SCHEMA public TO hades;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO hades;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON TABLES TO hades;
\c netflix
```


| Integration               |
|---------------------------|
| MyBatis                   |
| ElasticSearch             |
| Jenkins                   |
| Zipkin                    |
| Kong API                  |
| Apache Kafka              |
| PostgreSQL                |
| Flyway                    |
| Apache Spark              |
| Apache NiFi               |
| Kubernetes                |
| Docker                    |
| Redis                     |
| Ehcache                   |
| OAuth, JWT, encryption    |
| JUnit, Mockito, or TestNG |   

