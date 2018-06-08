Zadanie ANT - ZWIWO

```
cd zwiwo-ant
mvn install
cd ..

sudo docker image build --tag mbartos/ant:1.0 .
sudo docker container run --detach --name ant mbartos/ant:1.0
sudo docker container logs ant
```
