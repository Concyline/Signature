# Diretrizes de Interface

## 1. Escopo observado

A interface presente no repositório pertence ao app Android demonstrativo, não à API visual da biblioteca consumida por aplicações externas. A biblioteca oferece a View `br.com.signature.SignaturePad`, que deve poder ser incorporada em telas Android pelo consumidor.

Não foi encontrada especificação de design system, identidade visual de produto, matriz de telas ou tema oficial além dos recursos Android versionados.

## 2. Interface de demonstração existente

O layout `app/src/main/res/layout/activity_main.xml` usa `ConstraintLayout` com:

- `SignaturePad` para entrada por toque;
- botão para limpar o desenho;
- botão que obtém a bitmap e a exibe em `ImageView`.

A `MainActivity` define a cor da caneta como preta e liga os eventos de estado da assinatura. Os rótulos atuais no XML são “Clear” e “Save”; isso diverge da regra de `AGENTS.md`, que exige textos visíveis ao usuário em português.

## 3. Comportamento verificável da biblioteca

- A View respeita os limites de tamanho definidos pelo layout do consumidor.
- Os atributos XML existentes são `penMinWidth`, `penMaxWidth`, `penColor`, `velocityFilterWeight` e `clearOnDoubleClick`.
- A biblioteca permite consultar se a assinatura está vazia e notifica o listener no início do gesto, quando há assinatura e quando ocorre limpeza.
- `clearOnDoubleClick` é falso por padrão no código.
- A `SignaturePad` preserva a cor de caneta configurada no modo claro e usa branco no modo noturno; a tela demonstrativa deixa a View transparente para revelar a superfície temática e a prévia usa a saída transparente.
- O app demonstrativo usa `EdgeToEdge.enable`; não foi identificada configuração equivalente de insets no seu layout.

## 4. Diretrizes para mudanças futuras

- Mantenha textos de interface em recursos Android (`strings.xml`) em vez de hardcoding no layout.
- Textos visíveis ao usuário devem estar em português, conforme `AGENTS.md`.
- Preserve atributos, eventos e comportamento público existentes da `SignaturePad`, salvo requisito explícito e revisão do impacto em consumidores.
- Verifique toque, limpeza, exportação e estados vazio/assinado em dispositivo ou testes apropriados; os testes atuais não cobrem esses fluxos.
- Trate acessibilidade, localização, comportamento de insets e adaptação a diferentes telas como requisitos a confirmar antes de estabelecê-los como padrão do produto.

## 5. Pendências de produto

Design system e cores de produto; requisitos de acessibilidade; dimensões mínimas da área de assinatura; comportamento esperado em rotação e telas de diferentes tamanhos. Os rótulos em inglês identificados são uma divergência entre o código e as instruções do projeto.
