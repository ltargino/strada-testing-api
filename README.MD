# Rest Assured - API JSONPlaceholder

Este projeto utiliza a API https://jsonplaceholder.typicode.com/, uma API pública para realização de testes. 

Neste desafio, foi contemplado o cenário de método POST desta API, retornando 100 posts.

Para a validação dos testes, foi considerado o seguinte cenário:

 - Http Status Code igual a 200;
 - Conteúdo presente no body da resposta;
 - Validação de um post específico, avaliando se o mesmo está presente no retorno.

### Pré-requisitos

- JAVA_HOME configurada;
- MAVEN_HOME configurada;
- Variável de ambiente PATH contendo JAVA_HOME, MAVEN_HOME e o diretório de binários da Allure;

### Execução

- Download de dependências

``
mvn install
``

- Testes

``
mvn test
``

- Allure Report (Geração dos dados no diretório)

``
mvn allure:report
``

- Allure Server (Página de exibição dos resultados Allure)

``
mvn allure:serve
``