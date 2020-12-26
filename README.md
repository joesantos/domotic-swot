# Instruções para inicialização do sistema

## Para colaboradores, sobre Git, Github

Isto dá textão, mas, para encurtar, quando há mais de um colaborador, antes de comecar os trabalhos do dia, é bom verificar se sua cópia local está sincronizada com a cópia remota. Para isso, uso `git pull`. 

Caso falhe, o mais provável é que seu repositório local foi modificado mas o `commit` não foi feito. Acontece... 

- a situação provavelmente é que seu repositório local contém um ramo com modificações e o ramo remoto contém outras modificações. Há pelo menos dois jeitos de resolver isso:
    1. receita que *começa* com *unmerged files*. Mais na **simulação 1** desta [referência](https://github.com/camilabezerril/ImageCV/tree/master/Documentos/sobreGit#etapas-iniciais)
    2. receita que *começa* com `git stash`. Mais [nesta referência](https://github.com/camilabezerril/ImageCV/blob/master/Documentos/sobreGit/ramos.md#criar-novo-ramo)

**Importante** `git init` e a opção `--force` não são recomendadas nessa situação pois o trabalho feito pelo colaborador pode ser apagado. O trabaho pode ser recuperado pois está na cópia local do colaborador, mas, é retrabalho...

Fora essas opções, dificilmente perde-se dados com um versionador.

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

1. Descompacte o arquivo baixado, pode mover a pasta (diretório) para onde for mais conveniente. 
    - É desnecessário ser admin do sistema ou usar `sudo`;
    - No computador já há Jena instalado e configurado (não sei se é requisito para instalar Fuseki). 
2. Entre no diretório e execute:
``` 
fuseki-server
```
3. Para checar (superficialmente) a instalação, entre no navegador e digite na barra de endereço: `localhost:3030`. Algo parecido com a tela abaixo deve ser mostrado.

![alt text](Captura%20de%20tela%20de%202020-12-26%2010-08-32.png)

Caso deseje, ou precise instalar Jena, em 2020-12-26, a página de download é a mesma de Fuseki, mencionada acima. Há uma ou duas variáveis de ambiente para ajustar, [informação no github de colega da equipe de trabalho](https://github.com/FNakano/Gestao/blob/main/ExecucaoTutoriaisJena.md#1-instalar-jena).


## Adicionando base de conhecimento ao Fuseki Server

Faça upload da base de conhecimento inicial disponibilizada na seção Base de conhecimento inicial

## Executando aplicação server

Abra a pasta client no terminal/cmd/powershell e digite ```./gradlew run```

## Executando aplicação client

Abra a pasta client no terminal e digite o comando ```npm install``` para baixar as dependências da aplicação e em seguida ```npm start``` 

(Necessário ter o Node e npm instalados na máquina)

[mapa do site](sitemap.md) *o mapa do site foi gerado com `tree -H . -o sitemap.md`. É de estranhar gerar um html com extensão md, mas é simples e funciona para o propósito. Explora a capacidade do markdown conter html. Se a extensão for html, o github abre no modo editor de html ao invés de renderizar.*


