### forum-api ###

# radando jar

Na pasta raiz do projeto (/forum-api)
mvn clean install

naveque até a pasta targer (/forum-api/target) e certifiquese se existe o jar. Ex : forum.jar

java -jar -DFORUM_DATABASE_URL=DATABASE:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 forum.jar

#Docker

cria imagem
docker build -t br/forum .

roda container
docker run -p 8080:8080 -e FORUM_DATABASE_URL='jdbc:h2:mem:br-forum' -e FORUM_DATABASE_USERNAME='sa' -e FORUM_DATABASE_PASSWORD='' -e FORUM_JWT_SECRET='123456' -e SPRING_PROFILES_ACTIVE='prod' br/forum

#heroku
Na pasta raiz do projeto (/forum-api)

heroku login

heroku container:login

heroku create br-forum

heroku git:remote -a br-forum

- configurar variaves de ambiente no heroku
	- settings -> config vars
	 	FORUM_DATABASE_URL='jdbc:h2:mem:br-forum' 
	 	FORUM_DATABASE_USERNAME='sa' 
		FORUM_DATABASE_PASSWORD='' 
		FORUM_JWT_SECRET='123456'
		SPRING_PROFILES_ACTIVE='prod'
		
- executar
heroku container:push web
heroku container:release web
heroku open	


Você já pode testar: 
https://br-forum.herokuapp.com/topicos
