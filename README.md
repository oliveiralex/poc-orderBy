# Entendendo a cláusula ORDER BY do SQL 

#### DevSuperior - Alexandre Oliveira

Siga-nos:

https://instagram.com/devsuperior.ig

https://youtube.com/devsuperior


## Trechos de código

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

```sql
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Grande Sertão: Veredas', 'Nova Fronteira', 2006, 'João Guimarães Rosa');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Grande Sertão: Veredas', 'Nova Fronteira', 2015, 'João Guimarães Rosa');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Grande Sertão: Veredas', 'Companhia das Letras', 2019, 'João Guimarães Rosa');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Dom Casmurro', 'Penguin Companhia das Letras', 2016, 'Machado de Assis');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Dom Casmurro', 'Antofágica', 2020, 'Machado de Assis');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Sagarana', 'Nova Fronteira', 2015, 'João Guimarães Rosa');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Sagarana', 'Global', 2019, 'João Guimarães Rosa');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Quincas Borba', 'Penguin Companhia das Letras', 2012, 'Machado de Assis');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Quincas Borba', 'Antofágica', 2021, 'Machado de Assis');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Vidas Secas', 'Record', 2014, 'Graciliano Ramos');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Vidas Secas', 'Record', 2018, 'Graciliano Ramos');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Cem Anos de Solidão', 'Record', 2014, 'Gabriel García Márquez');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Cem Anos de Solidão', 'Record', 2019, 'Gabriel García Márquez');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Crime e Castigo', 'Todavia', 2019, 'Fiódor Dostoiévski');
INSERT INTO tb_book(name,publisher,publication_date,author) VALUES('Crime e Castigo', 'Editora 34', 2019, 'Fiódor Dostoiévski');
```

### Sorting With the OrderBy Method Keyword

```java
public List<Book> findByOrderByNameAsc();

public List<Book> findByOrderByAuthorAscPublicationDateDesc();
```

```java
@GetMapping(value = "/sortByName")
public ResponseEntity<List<Book>> findOrderByName() {
  List<Book> result = repository.findByOrderByNameAsc();
  return ResponseEntity.ok(result);
}

@GetMapping(value = "/sortByAuthorAndDate")
public ResponseEntity<List<Book>> findOrderByAuthorAndDate() {
  List<Book> result = repository.findByOrderByAuthorAscPublicationDateDesc();
  return ResponseEntity.ok(result);
}
```

### Sorting with a Sort Parameter

```java
@GetMapping(value = "/sortByName")
public ResponseEntity<List<Book>> findOrderByName() {
  List<Book> result = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
  return ResponseEntity.ok(result);
}

@GetMapping(value = "/sortByAuthorAndDate")
public ResponseEntity<List<Book>> findOrderByAuthorAndDate() {
  Sort sort = Sort.by(Sort.Order.asc("author"), Sort.Order.desc("publicationDate"));
  List<Book> result = repository.findAll(sort);
  return ResponseEntity.ok(result);
}
```
