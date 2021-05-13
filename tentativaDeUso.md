## 2021-01-05-175825

- Iniciei o servidor usando `sh gradlew run`. Tive a impressão que foram instalados Jena 3.14 e Tomcat. [Foto do terminal](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-23-33.png)
- O servidor Tomcat iniciou na porta 8080, então tentei a URL `localhost:8080`. Deu um *whitelabel error page*. [Foto do navegador](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-25-06.png)
- Percebi que não tinha iniciado Fuseki, então dei um CTRL-C no gradlew, abri um outro terminal, iniciei Fuseki:
<pre><font color="#859900"><b>abio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/apache-jena-fuseki-3.17.0</b></font>$ ./fuseki-server 
17:44:35 INFO  Server          :: Apache Jena Fuseki 3.17.0
17:44:36 INFO  Config          :: FUSEKI_HOME=/home/fabio/apache-jena-fuseki-3.17.0/.
17:44:36 INFO  Config          :: FUSEKI_BASE=/home/fabio/apache-jena-fuseki-3.17.0/run
17:44:36 INFO  Config          :: Shiro file: file:///home/fabio/apache-jena-fuseki-3.17.0/run/shiro.ini
17:44:36 INFO  Config          :: Configuration file: /home/fabio/apache-jena-fuseki-3.17.0/run/config.ttl
17:44:36 INFO  Config          :: Load configuration: file:///home/fabio/apache-jena-fuseki-3.17.0/run/configuration/mydataset.ttl
17:44:37 INFO  Server          :: Configuration file: /home/fabio/apache-jena-fuseki-3.17.0/run/config.ttl
17:44:37 INFO  Server          :: Path = /mydataset
17:44:37 INFO  Server          :: System
17:44:37 INFO  Server          ::   Memory: 4,0 GiB
17:44:37 INFO  Server          ::   Java:   11.0.9.1
17:44:37 INFO  Server          ::   OS:     Linux 5.4.0-59-generic amd64
17:44:37 INFO  Server          ::   PID:    13482
17:44:37 INFO  Server          :: Started 2021/01/05 17:44:37 BRT on port 3030
</pre>
- Reiniciei gradlew, iniciou na porta 8080, com o mesmo erro. [Foto do navegador 1](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-45-08.png).
- Pela [Foto do navegador 2](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-48-23.png) dá para acreditar que a requisição do navegador foi atendida, com a página de erro como resposta, pelo servidor Tomcat.
- Achei possível que só conseguisse usar com o cliente, então instalei o cliente com `npm install` na pasta client. Deu um warning. [Foto do terminal](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-50-23.png)
- Quando executei com `npm start`, abriu uma URL no navegador, com a mensagem *Failed to compile*. [Foto do terminal](tentativaDeUso-imagens/Captura%20de%20tela%20de%202021-01-05%2017-51-38.png). [Foto do terminal](Captura%20de%20tela%20de%202021-01-05%2017-53-40.png)

