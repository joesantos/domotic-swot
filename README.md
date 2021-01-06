# Instruções para inicialização do sistema

## Para colaboradores, sobre Git, Github

Isto dá textão, mas, para encurtar, quando há mais de um colaborador trabalhando no mesmo ramo (acho que é comum em projetos pequenos com equipes pequenas), me parece boa prática sincronizar no começo do dia e _comitar_ no fim do dia. Então...

...antes de comecar os trabalhos do dia, é bom verificar se sua cópia local está sincronizada com a cópia remota. Para isso, uso `git pull`.

Caso falhe, o mais provável é que seu repositório local foi modificado mas o `commit` não foi feito. Acontece...

- a situação provavelmente é que seu repositório local contém um ramo com modificações e o ramo remoto contém outras modificações. Há pelo menos dois jeitos de resolver isso:
  1. receita que _começa_ com _unmerged files_. Mais na **simulação 1** desta [referência](https://github.com/camilabezerril/ImageCV/tree/master/Documentos/sobreGit#etapas-iniciais)
  2. receita que _começa_ com `git stash`. Mais [nesta referência](https://github.com/camilabezerril/ImageCV/blob/master/Documentos/sobreGit/ramos.md#criar-novo-ramo)

**Importante** `git init` e a opção `--force` não são recomendadas nessa situação pois o trabalho feito pelo colaborador pode ser apagado. O trabaho pode ser recuperado pois está na cópia local do colaborador, mas, é retrabalho...

Fora essas opções, dificilmente perde-se informação com um versionador.

## Downloads

### Jena Fuseki Server

https://jena.apache.org/download/

Faça download do Apache Jena Fuseki. (.zip ou .tar.gz)
![Exemplo](https://bit.ly/3hzhn7Q)

### Base de conhecimento inicial

https://bit.ly/2Ci8gIB

## Rodando Fuseki Server

### Windows

Descompacte o arquivo baixado e execute o fuseki-server.bat

### Linux

#### Versões

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cat /etc/os-release 
NAME=&quot;Ubuntu&quot;
VERSION=&quot;20.04.1 LTS (Focal Fossa)&quot;
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME=&quot;Ubuntu 20.04.1 LTS&quot;
VERSION_ID=&quot;20.04&quot;
HOME_URL=&quot;https://www.ubuntu.com/&quot;
SUPPORT_URL=&quot;https://help.ubuntu.com/&quot;
BUG_REPORT_URL=&quot;https://bugs.launchpad.net/ubuntu/&quot;
PRIVACY_POLICY_URL=&quot;https://www.ubuntu.com/legal/terms-and-policies/privacy-policy&quot;
VERSION_CODENAME=focal
UBUNTU_CODENAME=focal
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ javac --version
javac 11.0.9.1
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ echo $PATH
/home/fabio/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/fabio/apache-jena-3.17.0/bin
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ echo $JENA_HOME
/home/fabio/apache-jena-3.17.0
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 


</pre>

#### Instruções

1. Descompacte o arquivo baixado, pode mover a pasta (diretório) para onde for mais conveniente.
   - É desnecessário ser admin do sistema ou usar `sudo`;
   - No computador já há Jena instalado e configurado (não sei se é requisito para instalar Fuseki).
2. <a name="inicia-fuseki" /> Isto inicia fuseki: Entre no diretório e execute:

```
fuseki-server
```

3. Para checar (superficialmente) a instalação, entre no navegador e digite na barra de endereço: `localhost:3030`. Algo parecido com a tela abaixo deve ser mostrado.

![alt text](Captura%20de%20tela%20de%202020-12-26%2010-08-32.png)

Caso deseje, ou precise instalar Jena, em 2020-12-26, a página de download é a mesma de Fuseki, mencionada acima. Há uma ou duas variáveis de ambiente para ajustar, [informação no github de colega da equipe de trabalho](https://github.com/FNakano/Gestao/blob/main/ExecucaoTutoriaisJena.md#1-instalar-jena).

## Adicionando base de conhecimento ao Fuseki Server

Faça upload da base de conhecimento inicial disponibilizada na seção Base de conhecimento inicial. Para isto:

1. [Inicie fuseki](README.md#inicia-fuseki)
2. No navegador, acesse fuseki
   - na configuração padrão isto se faz digitando na barra de endereço `localhost:3030`
3. Crie um dataset [foto da tela](diario/Captura%20de%20tela%20de%202020-12-28%2011-10-27.png)
4. Faça _upload_ do arquivo no dataset [foto da tela](diario/Captura%20de%20tela%20de%202020-12-28%2011-10-42.png)
5. Resultado: [foto da tela resultante](diario/Captura%20de%20tela%20de%202020-12-28%2011-11-38.png)

Com isto já é possível navegar na base de conhecimento, por exemplo, editar:

![alt text](diario/Captura%20de%20tela%20de%202020-12-28%2011-11-58.png)

ou consultar usando SPARQL:

![alt text](diario/Captura%20de%20tela%20de%202020-12-28%2011-13-43.png)

**notas**: estas instruções servem para qualquer Sistema Operacional.

na pasta `diario` há mais screenshots, os nomes foram atribuídos em ordem cronológica, o que permite recuperar mais detalhes.

## Executando aplicação server

Abra a pasta client no terminal/cmd/powershell e digite `./gradlew run`

`gradlew.bat` é um arquivo _batch_ para windows, `gradlew` é um _shell script_ para UNIX. Quando clonei o repositório, ele não veio com o flag de execução ativado. Executei usando `sh gradlew`. Existe a alternativa de ativar o flag de execução com `chmod`.

**Resultado no Ubuntu**

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ ls
build.gradle  <font color="#268BD2"><b>gradle</b></font>  gradlew  gradlew.bat  <font color="#268BD2"><b>src</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ ./gradlew
bash: ./gradlew: Permissão negada
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ sh gradlew
Downloading https://services.gradle.org/distributions/gradle-5.2.1-all.zip
..............................................................................................................................

Welcome to Gradle 5.2.1!

Here are the highlights of this release:
 - Define sets of dependencies that work together with Java Platform plugin
 - New C++ plugins with dependency management built-in
 - New C++ project types for gradle init
 - Service injection into plugins and project extensions

For more details see https://docs.gradle.org/5.2.1/release-notes.html

Starting a Gradle Daemon (subsequent builds will be faster)

<b>&gt; Task :help</b>

Welcome to Gradle 5.2.1.

To run a build, run <b>gradlew &lt;task&gt; ...</b>

To see a list of available tasks, run <b>gradlew tasks</b>

To see a list of command-line options, run <b>gradlew --help</b>

To see more detail about a task, run <b>gradlew help --task &lt;task&gt;</b>

For troubleshooting, visit <b>https://help.gradle.org</b>

<font color="#859900"><b>BUILD SUCCESSFUL</b></font> in 1m 17s
1 actionable task: 1 executed
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ 

</pre>

## Executando aplicação client

Abra a pasta client no terminal e digite o comando `npm install` para baixar as dependências da aplicação e em seguida `npm start`

**Resultado**
![alt text](diario/Captura%20de%20tela%20de%202020-12-28%2012-13-11.png)

![alt text](diario/Captura%20de%20tela%20de%202020-12-28%2012-13-45.png)

**nota**: Necessário ter o Node e npm instalados na máquina

No Ubuntu 20.04LTS, partes do Node são instaladas automaticamente com a distribuição, entre elas, o `npm`

[mapa do site](sitemap.md) _o mapa do site foi gerado com `tree -H . -o sitemap.md`. Todos os arquivos são listados, o .gitignore é ignorado, logo há arquivos na árvore que não estão no github. É de estranhar gerar um html com extensão md, mas é simples e funciona para o propósito. Explora a capacidade do markdown conter html. Se a extensão for html, o github abre no modo editor de html ao invés de renderizar._

## Implementação

Como pôde ser visto acima, a solução possui duas aplicações, a client e server, que interagem entre si através chamadas REST.

### Server

A aplicação server é escrita utilizando Spring Boot, na linguagem Java, e a primeira camada consiste nas classes Resource (FeatureOfInterestResource na imagem abaixo é um exemplo da estrutura das classes Resource), responsáveis por expor a interface RESTful.

![alt text](diario/Captura%20de%20tela%202020-12-30%20015903.png)

A partir dos `@getMapping` e `@postMapping` ocorre a conexão do endpoint exposto com o método responsável por executar os métodos que interagem de fato com a base de conhecimento.

Utilizando a interface criada pelas classes Resource, as classes Service são responsáveis por realizarem de fato a integração com a camada de ontologia do sistema, realizando as chamadas SPARQL via Fuseki Server e fazendo as leituras e atualização na base de conhecimento utilizando Jena para manipular os resultados obtidos nas interações com a base de conhecimento.

![alt text](diario/Captura%20de%20tela%202021-01-06174822.png)

Acima podemos ver um exemplo de uma query sendo realizada na classe Service e a captura do Resource sendo feita através da classe `Resource` do Jena.

### Inserção de um novo dispositivo

A inserção de um novo dispositivo consiste em adicionar o FeatureOfInterest desejado e todas as suas dependências, caso não tenham sido inseridas anteriormente. Segue um exemplo abaixo de inserção de um novo dispositivo utilizando SPARQL

```
INSERT DATA{
    :sala-tv-1 a owl:NamedIndividual, :Room, sosa:Platform ;
    sosa:hosts :light-sensor-sala-tv-1 ;
    sosa:hosts :lampada-sala-tv-1-switch ;
    ssn:implements :switch-on-lampada-sala-tv-1 ;
    ssn:implements :switch-off-lampada-sala-tv-1 .

};

INSERT DATA{
    :switch-on-lampada-sala-tv-1 a owl:NamedIndividual, sosa:Actuation ;
    sosa:hasSimpleResult "on" ;
    sosa:actsOnProperty :set-intensity-lampada-sala-tv-1 ;
    sosa:madeByActuator :lampada-sala-tv-1-switch ;
    sosa:resultTime: NOW () .
};

INSERT DATA{
    :switch-off-lam pada-sala-tv-1 a owl:NamedIndividual, sosa:Actuation ;
    sosa:hasSimpleResult "off" ;
    sosa:actsOnProperty :set-intensity-lampada-sala-tv-1 ;
    sosa:madeByActuator :lampada-sala-tv-1-switch ;
    sosa:resultTime: NOW ()
};

INSERT DATA{
    :light-sensor-sala-tv-1 a owl:NamedIndividual, :LightSensor ;
    sosa:observes :intensity-lampada-sala-tv-1 ;
    sosa:madeObservation :observation-intensity-lampada-sala-tv-1 ;
    sosa:isHostedBy :sala-tv-1 .
};

INSERT DATA {
	:set-intensity-lampada-sala-tv-1 a owl:NamedIndividual, :SetIntensity ;
    ssn:isPropertyOf :lampada-sala-tv-1 .
};


INSERT DATA {
	:intensity-lampada-sala-tv-1 a owl:NamedIndividual, :Intensity ;
    ssn:isPropertyOf :lampada-sala-tv-1 .
};

INSERT DATA{
    :observation-intensity-lampada-sala-tv-1 a owl:NamedIndividual, sosa:Observation;
    sosa:hasSimpleValue rdfs:Literal;
    sosa:resultTime xsd:dateTimeStamp;
    sosa:madeBySensor :light-sensor-sala-tv-1;
    sosa:hasFeatureOfInterest :lampada-sala-tv-1 .
};

INSERT DATA{
    :lampada-sala-tv-1 a owl:NamedIndividual, :Lamp ;
    ssn:hasProperty :intensity-lampada-sala-tv-1 ;
    ssn:hasProperty :set-intensity-lampada-sala-tv-1 .
};

INSERT DATA{
	:lampada-sala-tv-1-switch a owl:NamedIndividual, :LightSwitch;
    sosa:isHostedBy :sala-tv-1;
    ssn:forProperty :set-intensity-lampada-sala-tv-1;
    sosa:madeActuation :switch-on-lampada-sala-tv-1 .
};
```

### Leitura

### Atualização
