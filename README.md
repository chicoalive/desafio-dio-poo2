# Desafio DIO - Modelagem de um Bootcamp com POO em Java

## Descrição

Este projeto foi desenvolvido como parte de um desafio da DIO com foco em **Programação Orientada a Objetos (POO)** utilizando Java. O objetivo é modelar o domínio de uma plataforma de bootcamps, aplicando conceitos como abstração, herança, encapsulamento e polimorfismo [web:971][web:953].

No sistema, existem conteúdos educacionais como cursos e mentorias, que podem ser associados a um bootcamp. Os desenvolvedores se inscrevem no bootcamp, progridem nos conteúdos e acumulam XP conforme avançam na jornada [web:953][web:978].

## Objetivo do desafio

Praticar os principais pilares da orientação a objetos por meio da criação de classes e relacionamentos que representem um cenário real de aprendizagem em uma plataforma de cursos [web:971][web:973].

## Conceitos aplicados

- Abstração
- Encapsulamento
- Herança
- Polimorfismo
- Collections com `Set`
- Organização em camadas de classes e entidades [web:969][web:971]

## Estrutura do projeto

O projeto foi modelado com as seguintes classes principais:

### `Conteudo`
Classe abstrata responsável por representar os dados e comportamentos comuns entre os conteúdos da plataforma, como título, descrição e cálculo de XP.

### `Curso`
Especialização de `Conteudo` que adiciona a carga horária do curso.

### `Mentoria`
Especialização de `Conteudo` que adiciona a data da mentoria.

### `Bootcamp`
Classe responsável por agrupar os conteúdos e os desenvolvedores inscritos.

### `Dev`
Representa o desenvolvedor inscrito no bootcamp, com controle dos conteúdos inscritos, conteúdos concluídos e total de XP acumulado.

### `Program`
Classe utilizada para execução e testes do sistema.

## Regras de negócio

- Um bootcamp possui nome, descrição, conteúdos e desenvolvedores inscritos.
- Um desenvolvedor pode se inscrever em um bootcamp.
- Ao se inscrever, o dev recebe os conteúdos cadastrados no bootcamp.
- Ao progredir, o conteúdo sai da lista de inscritos e vai para a lista de concluídos.
- O XP total é calculado com base nos conteúdos concluídos.
- Cursos e mentorias possuem regras diferentes para cálculo de XP.

## Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Git e GitHub [web:969][web:953]

## Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/chicoalive/desafio-dio-poo2.git
   ```

2. Abra o projeto em sua IDE Java de preferência.

3. Execute a classe `Program` para visualizar o funcionamento do desafio [web:953][web:975].

## Autor

Projeto desenvolvido por Francisco De Assis como prática de Java e POO no desafio da DIO.
