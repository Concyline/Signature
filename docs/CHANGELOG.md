# Changelog

> ⚠️ **REGRA OBRIGATÓRIA PARA AGENTES DE IA**
>
> Todo agente de IA que modificar este projeto deve registrar neste arquivo as alterações relevantes realizadas.
>
> O registro deve ser criado após uma alteração concluída e validada, contendo contexto suficiente para que outros agentes compreendam:
>
> - O que foi alterado.
> - Por que foi alterado.
> - Quais componentes foram afetados.
> - Quais cuidados devem ser considerados em futuras alterações.
>
> Este documento é uma fonte histórica oficial do projeto.
>
> **Propósito como scaffold genérico:** Este arquivo serve como histórico evolutivo de qualquer projeto novo. Ele não fixa decisões técnicas permanentes; ao contrário, ele registra o que foi validado, permitindo que agentes e desenvolvedores acompanhem o crescimento da base documental e do código.

---

# Objetivo

Este arquivo documenta a evolução técnica do projeto, mantendo histórico das alterações realizadas em:

- Código-fonte.
- Estrutura arquitetural.
- Banco de dados.
- APIs.
- Componentes frontend.
- Configurações.
- Dependências.
- Regras de negócio.

O Changelog deve auxiliar desenvolvedores e agentes de IA na manutenção segura do sistema.

---

# Padrão do documento

Este histórico segue a estrutura de [Keep a Changelog](https://keepachangelog.com/en/1.0.0/). O uso de Semantic Versioning para releases do projeto não foi confirmado; não inferir uma política de versionamento a partir deste formato.

Todas as alterações documentais e técnicas relevantes devem ser registradas após a conclusão. Entradas em `[Unreleased]` não representam releases publicadas.

## [Unreleased]

### Added

- Documentada a arquitetura Android observada, os módulos `:app` e `:signature`, instruções de configuração e limites conhecidos da distribuição.
- Registradas as capacidades atuais de captura e exportação de assinaturas e a documentação técnica dos módulos e da View `SignaturePad`.
- Adaptação de cor da `SignaturePad` para modo noturno, com traço claro, recoloração do desenho existente e SVG com a cor efetiva; tela de demonstração usa superfície temática e prévia transparente.
- Criado `POPULACAO_CHECKLIST.md` com o fluxo para transformar o scaffold documental em documentação oficial de um projeto real.
- Adicionado o checklist ao índice e à árvore de documentação do `AGENTS.md`.
- Criados templates para funcionalidades, planos, erros, incidentes, lições aprendidas, componentes compartilhados e documentação técnica de módulos.
- Mantidos os `README.md` como guias operacionais de cada diretório, com links para os templates correspondentes.
- Criada `KNOWLEDGE/REFERENCE/` para armazenar projetos e artefatos técnicos autorizados como fonte auxiliar de consulta e treinamento operacional dos agents.
- Criada `KNOWLEDGE/REFERENCE/PROJECTS/` como local isolado para armazenar os projetos de referência.
- Documentado o fluxo completo de inclusão, sanitização, classificação, catalogação e consulta dos projetos de referência.
- Adicionados modelos `PROJECTS/TEMPLATE.md` e `PROJECTS/REFERENCE_METADATA_TEMPLATE.yml` para padronizar o cadastro de cada projeto.
- Incluído o cadastro de projetos de referência no `POPULACAO_CHECKLIST.md` e na tabela de documentação por tipo de tarefa do `AGENTS.md`.
- Criado `KNOWLEDGE/REFERENCE/TRAINING.md` com o ciclo de treinamento operacional por consulta, comparação, adaptação, validação e registro.

### Changed

- Atualizado o Android Gradle Plugin de 8.12.1 para 8.13.2, conforme aprovado durante esta tarefa.
- Reforçada a distinção entre template genérico, hipótese e decisão oficial.
- Corrigidas pequenas inconsistências textuais nos documentos de conhecimento e aprendizado.
- Melhorado o `AGENTS.md` com hierarquia de prioridades, níveis de autonomia, protocolo de evidências, validação adaptativa, formato de saída, regras de débito técnico e referências de ferramentas mais genéricas.

---