# Locadora de Veículos

    Santander Coders - Ada Tech
    Módulo POO-II

    #Status: Projeto em desenvolvimento

# Descrição do Projeto

Criar uma aplicação que gerencie o aluguel de veículos, aplicando os conceitos vistos em aula.

## Itens obrigatórios


    Cadastrar os veículos;

    Alterar um veículo cadastrado;

    Buscar um veículo por parte do nome;

    Cadastrar o cliente (pessoa física e jurídica)

    Alterar o cliente (pessoa física e jurídica)

    Alugar um veículo para pessoa física e jurídica;

    Devolver um veículo para pessoa física e jurídica;

## Regras de negócio


    RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;

    RN2: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;

    RN3: Os aluguéis e devoluções terão o local, data e horário;

    RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.

    RN5: Os veículos que estiverem alugados não poderão estar disponíveis;

    RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
    
    RN7: Regras de devolução:
        Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
        Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.

    Valores base da diária por tipo de veículo:

    | Tipo de Veículo | Valor por dia | | --------------- | ------------- | | PEQUENO | R100,00∣∣MEDIO∣R100,00∣∣MEDIO∣R 150,00 | | SUV | R$ 200,00 |


# Conceitos

O projeto visa explorar o uso de generics para potencializar a reutilização de código e buscar a segurança de tipos em tempo de compilação. Além disso, busca-se aplicar os princípios SOLID de maneira aprimorada, visando promover a modularidade e manutenibilidade do código. Outros conceitos de POO, como polimorfismo, herança e encapsulamento, são explorados com o intuito de criar uma base flexível e modular, embora a efetiva implementação possa variar conforme a complexidade do projeto e os desafios encontrados.
