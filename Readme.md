# Controle de Estoque de Revenda de Veículos
### Este é um projeto de controle de estoque de revenda de veículos desenvolvido com Spring Boot, Maven e Java.

![Descrição da imagem](image.jpg)


## Funcionalidades
- Cadastro de veículos (marca, modelo, ano, etc.)
- Consulta de veículos disponíveis
- Atualização de informações de veículos
- Remoção de veículos do estoque

## Pré-requisitos
- Java 11 ou superior
- Maven instalado

## Configuração
- Clone este repositório.
- Execute o aplicativo Spring Boot.

## Endpoints

- GET /carro: Retorna a lista de carros disponíveis.

- GET /motocicleta: Retorna a lista de motocicletas disponíveis.

- GET /carro/listarPreco: Retorna a lista de carros disponíveis por ordem de preço anunciado.

- GET /motocicleta/listarPreco: Retorna a lista de motocicletas disponíveis por ordem de preço anunciado.
- POST /carro: Adiciona um novo carro ao estoque.
- POST /motocicleta: Adiciona uma nova motocicleta ao estoque.
- PUT /carro/{id}: Atualiza as informações de um carro existente.
- PUT /motocicleta/{id}: Atualiza as informações de uma motocicleta existente.
- DELETE /carro/{id}: Remove um carro do estoque.
- DELETE /carro/{id}: Remove um carro do estoque.
- GET /carro/ipva/{id}:Retorna o valor do IPVA do carro existente.
- GET /motocicleta/ipva/{id}:Retorna o valor do IPVA do carro existente.
- GET /carro/blackfriday: Retorna desconto de 15% em todos os carros.
- GET /motocicleta/blackfriday: Retorna desconto de 15% em todos as motocicletas.


## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença
Este projeto está licenciado sob a MIT License.
