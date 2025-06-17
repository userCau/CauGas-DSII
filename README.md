# Documentação das Rotas - CauGás

##  Página Inicial

- **Rota:** `/principal`
- **Método:** GET
- **Permissão:** Público (qualquer usuário, logado ou não)
- **Descrição:** Tela inicial com informações gerais e links para ações.

---

##  Registro de Usuário

- **Rota:** `/register`
- **Método:** GET / POST
- **Permissão:** Público
- **Descrição:** Tela para cadastro de novos usuários.

---

##  Login

- **Rota:** `/login`
- **Método:** GET / POST
- **Permissão:** Público
- **Descrição:** Tela de autenticação do usuário.

---

##  Cadastro de Endereço / Cliente

- **Rota:** `/cadastro`
- **Método:** GET / POST
- **Permissão:** Qualquer usuário logado (admin ou comum)
- **Descrição:** Permite cadastrar novo cliente/endereço.

---

##  Listagem de Endereços / Clientes

- **Rota:** `/listagem`
- **Método:** GET
- **Permissão:** Somente usuários com o papel `ADMIN`
- **Descrição:** Lista todos os clientes cadastrados com opções de editar e excluir.

---

##  Atualizar Cliente

- **Rota:** `/atualizar/{id}`
- **Método:** GET / POST
- **Permissão:** Qualquer usuário logado
- **Descrição:** Atualiza os dados de um cliente específico.

---

##  Deletar Cliente

- **Rota:** `/deletar/{id}`
- **Método:** POST
- **Permissão:** Apenas `ADMIN`
- **Descrição:** Exclui um cliente específico.

-##  Acesso Negado

- **Rota:** `/acesso-negado`
- **Método:** GET
- **Permissão:** Automática via Spring Security
- **Descrição:** Página de erro para usuários sem permissão.

- ## Logout

- **Rota:** `/logout-sucesso`
- **Método:** GET
- **Permissão:** Automática via Spring Security
- **Descrição:** Pagina de confirmação do logout
---



