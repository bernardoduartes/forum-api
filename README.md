# forum-api

# radando jar

Na pasta raiz do projeto (/forum-api)
mvn clean install

naveque até a pasta targer (/forum-api/target) e certifiquese se existe o jar. Ex : forum.jar

java -jar -DFORUM_DATABASE_URL=DATABASE:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 forum.jar

#Docker

docker build -t br/forum .