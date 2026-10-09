# Funcionalidades

Esta pasta descreve capacidades observáveis ou requisitos confirmados do produto. Funcionalidades identificadas no código não devem ser interpretadas como regras de negócio adicionais.

## Escopo confirmado

O propósito confirmado do projeto é fornecer uma biblioteca Android reutilizável para desenhar e exportar assinaturas. O módulo `app` é uma demonstração técnica.

### Capacidades observadas na biblioteca

- Capturar gestos de desenho em uma View Android.
- Ajustar a largura do traço pela velocidade, respeitando larguras mínima/máxima configuráveis.
- Limpar e consultar o estado da área de desenho.
- Exportar bitmap transparente, bitmap composta em branco, bitmap com corte opcional e SVG.
- Notificar callbacks de início, assinatura e limpeza.
- Configurar cor, larguras, filtro de velocidade e limpeza por duplo toque.

Especificação do comportamento atual: [`CAPTURA_EXPORTACAO_ASSINATURA.md`](./CAPTURA_EXPORTACAO_ASSINATURA.md). Os detalhes técnicos estão em [`ARCHITECTURE.md`](../ARCHITECTURE.md). Não há critérios de aceite de produto ou política de retenção/armazenamento confirmados além do escopo acima.

Use [`TEMPLATE.md`](./TEMPLATE.md) para registrar especificações de novas funcionalidades após confirmar requisitos e critérios de aceite. O catálogo de features específicas permanece vazio até existir especificação aprovada.
