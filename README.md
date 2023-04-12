<h1>Projeto Spring Data JPA </h1>

<h2>🎯 Objetivo do Projeto</h2>
<p>Praticar os principais conceitos de mapeamento objeto relacional (ORM) usando o <strong>Spring Data JPA</strong>. Para isso, uma <strong>API RESTful</strong> foi desenvolvida com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.</p>

<h2>🛠 Tecnologias Utilizadas</h2>

<ul>
    <li>IDE IntelliJ</li>
    <li>Java 11</li>
    <li>Maven</li>
    <li><strong>Spring Web</strong></li>
    <li><strong>MySQL Driver</strong></li>
    <li><strong>Spring Boot DevTools</strong></li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>Hibernate Validator</strong></li>
    <li>Lombok</li>
    <li>Postman</li>
</ul>


<h2><a href="https://strn.com.br/artigos/2018/12/11/todas-as-anota%C3%A7%C3%B5es-do-jpa-anota%C3%A7%C3%B5es-de-mapeamento/"> Anotações de Mapeamento </a></h2>

<strong>@Entity</strong>
Usada para especificar que a classe anotada atualmente representa um tipo de entidade.

<strong>@Table</strong>
Usada para especificar a tabela principal da entidade atualmente anotada.

<strong>@Id</strong>
Especifica o identificador da entidade. Uma entidade deve sempre ter um atributo identificado.

<strong>@GeneratedValue</strong>
Especifica que o valor do identificador de entidade é gerado automaticamente.

<strong>@Column</strong>
Usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados.

<strong>@JoinColumn</strong>
Usada para especificar a coluna FOREIGN KEY. Indica que a entidade é a responsável pelo relacionamento.

<strong>@OneToMany</strong>
Usada para especificar um relacionamento de banco de dados um-para-muitos.

<strong>@OneToOne</strong>
Usada para especificar um relacionamento de banco de dados um-para-um.

<strong>@ManyToOne</strong>
Usada para especificar um relacionamento de banco de dados muitos-para-um.

<strong>cascade</strong>
Realizar operações em cascata só faz sentido em relacionamentos Pai - Filho.

<strong>mappedBy</strong>
Indica qual é o lado inverso ou não dominante da relação.


</br>
<h2>/ Rotas</h2>
</br>

>> * Para alunos

### GET - Listagem de alunos
```
http://localhost:8080/alunos
```

### POST - Cadastro de Aluno
```
http://localhost:8080/alunos

 {
        "nome": "Fulano Ciclano",
        "cpf": "023.234.456-87",
        "bairro": "Desenvolvedor FullStack",
        "dataDeNascimento": "01/01/1980"
    }

```

### PUT - Atualização de cadastro (aluno)
```
http://localhost:8080/alunos/id

 {
        "nome": "Ciclano Fulano",
        "bairro": "Rua Brasil",
        "dataDeNascimento": "01/01/1850"
    }

```

### DELETE - Exclusão de cadastro (aluno)
```
http://localhost:8080/alunos/id
```


</br>

>> * Para avaliações


### GET - Listagem de avaliações
```
http://localhost:8080/avaliacoes
```


### POST - Cadastro avaliação
```
http://localhost:8080/alunos

{
        "alunoId": 1,
        "peso": 80.0,
        "altura": 190.0
    }

```

### PUT - Atualização de avaliação
```
http://localhost:8080/avaliacoes/idAvaliacao

{
        "alunoId": 1,
        "peso": 80.0,
        "altura": 190.0
    }

```







<h2>🔗 Links Úteis</h2>
<ul>
    <li><a href="https://start.spring.io/">Spring Initializr</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/common-application-properties.html">Common application properties</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
</ul>






