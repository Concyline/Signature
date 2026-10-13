# Biblioteca de Assinatura Android

**Status:** `IMPLEMENTED`  
**Última atualização:** `2026-10-09`  
**Referência:** estado do código no repositório

## 1. Objetivo

Fornecer uma View Android reutilizável para desenhar assinaturas com toque e recuperar sua representação em bitmap ou SVG.

## 2. Responsabilidades e limites

**Inclui:** captura de gestos, construção de traços suavizados, armazenamento transitório em bitmap, estado vazio/assinado, callbacks, restauração de estado da View e serialização para os formatos expostos.

**Não inclui:** armazenamento permanente, envio remoto, autenticação, validação de identidade, assinatura criptográfica ou garantia de validade jurídica. Não foram encontrados esses recursos no código.

## 3. Localização

- `signature/src/main/java/br/com/signature/SignaturePad.java`
- `signature/src/main/java/br/com/signature/utils/`
- `signature/src/main/java/br/com/signature/view/`
- `signature/src/main/res/values/attrs.xml`
- Configuração Gradle em `signature/build.gradle`

## 4. Fluxo

`SignaturePad` recebe eventos de toque, mantém pontos temporizados, calcula curvas Bézier e desenha os pontos da curva na bitmap interna. A velocidade filtrada influencia a largura entre os limites configurados. Em paralelo, curvas são acumuladas pelo construtor SVG.

O consumidor pode limpar, consultar `isEmpty()`, observar `OnSignedListener`, obter bitmap transparente ou branca, solicitar corte de espaços vazios, obter SVG ou restaurar uma bitmap.

## 5. Configuração e eventos

Atributos XML: `penMinWidth`, `penMaxWidth`, `penColor`, `velocityFilterWeight`, `clearOnDoubleClick`. Os valores padrão observados no código são larguras 3dp e 7dp, cor preta, peso do filtro `0.9` e duplo toque desativado. A cor configurada é preservada em modo claro; em modo noturno a linha é branca. Ao mudar a configuração `uiMode`, os traços existentes também são recoloridos.

`OnSignedListener` expõe `onStartSigning()`, `onSigned()` e `onClear()`. O módulo também declara `SignaturePadBindingAdapter` para bindings Data Binding correspondentes.

## 6. Saídas e limitações observadas

- `getTransparentSignatureBitmap()` entrega a bitmap da área de desenho na cor efetiva do traço.
- `getSignatureBitmap()` gera a saída para documentos, sempre com fundo branco e escrita preta, inclusive no modo noturno.
- `getTransparentSignatureBitmap(true)` tenta cortar áreas vazias e retorna `null` se não há pixels desenhados.
- `getSignatureSvg()` gera SVG usando a cor efetiva da caneta, incluindo branco no modo noturno.
- Para exibir a assinatura sobre superfícies escuras, use a bitmap transparente; ela mantém a cor efetiva do traço.
- `setSignatureBitmap()` ajusta a bitmap fornecida aos limites da View usando `ScaleToFit.CENTER`.
- Não há persistência do desenho além do estado transitório/restaurável da View.

## 7. Dependências e validação

Módulo Android Library, Java 11, compile SDK 36, min SDK 23. Usa AndroidX/Material e a dependência de base do Data Binding declarada no catálogo Gradle. O app depende deste módulo.

Os testes unitários cobrem a resolução da cor para modo claro/noturno e a cor do SVG; desenho por toque e recoloração de bitmap em dispositivo ainda não têm cobertura automatizada. Consulte [`SETUP.md`](../../SETUP.md) para comandos Gradle.

## 8. Pontos de atenção

Trate mudanças em métodos públicos, atributos XML, eventos ou formatos como alterações de contrato para consumidores. Não presuma segurança jurídica, persistência, compatibilidade binária ou publicação baseada somente no nome do projeto ou metadados Maven.
