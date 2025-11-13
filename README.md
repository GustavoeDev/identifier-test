## Atividade Prática – Testes: Identifier

O programa Identifier tem como objetivo determinar se um identificador é válido ou não, conforme as seguintes regras:

  * Deve começar com uma letra (a-z ou A-Z)
  * Pode conter apenas letras ou dígitos (a-z, A-Z, 0-9)
  * Deve ter de 1 a 6 caracteres de comprimento (inclusive)

A função retorna um valor booleano indicando se o identificador é válido (true) ou inválido (false).

### 🔍 Análise de Particionamento em Classes de Equivalência

1.  **Comprimento do Identificador**
      * **Classes Válidas:**
          * CE1: Comprimento = 1 (valor limite mínimo)
          * CE2: Comprimento entre 2 e 5 (valores intermediários)
          * CE3: Comprimento = 6 (valor limite máximo)
      * **Classes Inválidas:**
          * CE4: Comprimento = 0 (vazio)
          * CE5: Comprimento \> 6 (muito longo)
2.  **Caractere Inicial**
      * **Classes Válidas:**
          * CE6: Primeira letra minúscula (a-z)
          * CE7: Primeira letra maiúscula (A-Z)
      * **Classes Inválidas:**
          * CE8: Primeiro caractere é dígito (0-9)
          * CE9: Primeiro caractere é símbolo especial (@, \#, \_, \!, etc.)
3.  **Caracteres Internos (posições 2-6)**
      * **Classes Válidas:**
          * CE10: Todos os caracteres são letras
          * CE11: Todos os caracteres são dígitos
          * CE12: Mistura de letras e dígitos
      * **Classes Inválidas:**
          * CE13: Contém espaços
          * CE14: Contém símbolos especiais (@, \#, \_, \!, etc.)

### 📊 Análise de Valor Limite
Os valores limite identificados são:

  * **Comprimento:**
      * Limite inferior: 0 (inválido), 1 (válido)
      * Limite superior: 6 (válido), 7 (inválido)
  * **Primeiro Caractere:**
      * Últimas letras minúsculas: 'z' (válido)
      * Primeiras letras maiúsculas: 'A' (válido)
      * Dígitos: '0', '9' (inválidos)
  * **Caracteres Internos:**
      * Transição letra-dígito: 'A1', 'z9' (válidos)
      * Símbolos adjacentes: 'A@', 'A\_' (inválidos)

### 📝 Tabela de Casos de Teste

| ID | Entrada | Regra Testada / Propósito | Resultado Esperado |
| :--- | :--- | :--- | :--- |
| CT01 | "a" | Comprimento Válido (Limite 1) | ✅ Válido |
| CT02 | "Abcdefg" | Comprimento Inválido (Limite 7) | ❌ Inválido |
| CT03 | "A1b2c3" | Começa com Letra | ✅ Válido |
| CT04 | "1abcde" | Não Começa com Letra (Dígito) | ❌ Inválido |
| CT05 | "A1b2c3" | Contém Apenas Letras e Dígitos | ✅ Válido |
| CT06 | "A@b" | Contém Caractere Especial | ❌ Inválido |

### 🚀 Como Executar os Testes Localmente
**Pré-requisitos**

  * Java JDK 8 ou superior
  * Maven 3.6 ou superior

**Passos para Execução**

1.  Clone o repositório:
    ```bash
    git clone <seu-repositorio>
    cd <seu-repositorio>
    ```
2.  Compile o projeto:
    ```bash
    mvn clean compile
    ```
3.  Execute os testes:
    ```bash
    mvn test
    ```
4.  Visualize o relatório de cobertura (opcional):
    ```bash
    mvn jacoco:report
    ```
    O relatório será gerado em: `target/site/jacoco/index.html`

**Estrutura do Projeto**

```
.
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Identifier.java
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   └── IdentifierTest.java
├── .github/
│   └── workflows/
│       └── testes.yml
├── pom.xml
└── README.md
```

### Automação com GitHub Actions
O projeto está configurado com GitHub Actions para executar os testes automaticamente em cada push ou pull request na branch principal.

**Workflow Configurado**
O arquivo `.github/workflows/testes.yml` executa:

  * Checkout do código
  * Configuração do ambiente Java 21
  * Execução dos testes com Maven
  * Geração de relatório de cobertura com Jacoco

**Como Visualizar**

1.  Acesse a aba **Actions** no seu repositório GitHub
2.  Visualize os workflows executados
3.  Clique em um workflow específico para ver os detalhes

### ✅ Resultados dos Testes

**Exemplo de Saída dos Testes**

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running org.example.IdentifierTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
