# Jokenpo (Pedra, papel, tesoura!)

Consiste em um sistema (Java) inspirado no desafio http://dojopuzzles.com/problemas/exibe/jokenpo/

## Backlog
O projeto foi inicialmente construído com ajuda do maven.
Pensou-se inicialmente no desenvolvimento do jogo completo, inclusive pedindo o input do usuário,
e escrevendo de volta todas as interacoes.

Depois revendo os requisitos do desafio ficou mais claro que a solução poderia ser mais simples, sem
pedir o input do usuário e simplesmente retornando qual jogador venceu.

Por isso existem duas classes, o JokenpoApp e o JokenpoJudge, o JokenpoJudge foi desenvolvido após o
App estar pronto inclusive com testes unitários.

```shell
#Inicializacao do projeto com maven usando java versao 8, posteriormente alterada para 11
mvn archetype:generate -DgroupId=com.example.jokenpo \
    -DartifactId=jokenpo \
    -DarchetypeGroupId=com.github.ngeor \
    -DarchetypeArtifactId=archetype-quickstart-jdk8 \
    -DarchetypeVersion=1.2.0 \
    -DinteractiveMode=false

```

## Desenvolvimento

Desenvolvimento local usando IDE (**Visual Studio Code**, Eclipse, Netbeans, etc)

### Build
```shell
#Faça as modificações nos arquivos e depois faça o build:
mvn clean install

#O jar final estará na pasta target
```


**Como realizar os testes automatizados**
Pode ser pela IDE ou através de linha de comando:
```shell
#lembre de estar dentro do diretório do projeto
mvn test
```

## Rodando o jar
Para rodar o jar do App:
```shell
#lembre de estar dentro do diretório do projeto. Para interromper a execução antes do fim do programa use Ctrl+c
java -cp target\jokenpo-1.0-SNAPSHOT.jar com.example.jokenpo.JokenpoApp
```

Para rodar o jar do Judge:
```shell
#lembre de estar dentro do diretório do projeto.
java -cp target\jokenpo-1.0-SNAPSHOT.jar com.example.jokenpo.JokenpoJudge pedra papel
```
