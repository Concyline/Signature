# Arquitetura do Projeto

**Estado:** descrição da implementação observada no repositório  
**Última verificação:** 2026-10-09

## 1. Objetivo e escopo confirmado

O projeto fornece uma biblioteca Android reutilizável para desenhar e exportar assinaturas. O módulo `app` é uma demonstração técnica da biblioteca, não o produto principal.

Esta documentação descreve o estado encontrado no código. Ela não define funcionalidades futuras, garantias de compatibilidade ou decisões de distribuição que não estejam registradas no repositório.

## 2. Visão geral

É um projeto Android nativo, escrito em Java, organizado como build Gradle multi-módulo. O app de demonstração depende da biblioteca; a biblioteca não depende do app.

```text
app (aplicativo demonstrativo)
 └── depende de
     signature (biblioteca Android)
```

Não foram encontrados módulos de servidor, banco de dados, persistência de assinaturas, autenticação ou integração de rede no código inspecionado.

## 3. Stack técnica confirmada

| Área | Tecnologia/configuração observada |
|---|---|
| Plataforma | Android |
| Linguagem | Java |
| Build | Gradle Wrapper 9.6.0; Android Gradle Plugin 9.4.1 |
| SDK de compilação | Android API 36 |
| SDK mínimo | API 23 nos módulos `app` e `signature` |
| SDK alvo | API 36 no módulo `app` |
| Compatibilidade Java | Java 11 nos dois módulos |
| UI do app de demonstração | Views XML, AppCompat, Material Components, Activity e ConstraintLayout |
| Testes | JUnit 4, AndroidX Test e Espresso declarados |
| Persistência/backend | Não encontrados |
| CI/CD e hospedagem | Não identificados no repositório |

As versões de bibliotecas estão centralizadas em `gradle/libs.versions.toml`.

## 4. Módulos e responsabilidades

### `:signature`

Biblioteca Android com namespace `br.com.signature`. Contém a View pública `SignaturePad`, atributos XML e utilitários para curvas, pontos, SVG e compatibilidade com Views. É responsável pela captura de gestos de desenho e pela geração dos formatos de saída disponíveis.

### `:app`

Aplicativo Android demonstrativo com uma `MainActivity` e um layout. Exibe a `SignaturePad`, permite limpar o desenho e mostra uma imagem bitmap em um `ImageView`. O botão apresentado como “Save” não grava arquivo nem persiste a assinatura; apenas exibe o bitmap na própria tela.

## 5. Contrato observado de `SignaturePad`

`br.com.signature.SignaturePad` estende `android.view.View`. Pode ser configurada por atributos XML:

| Atributo | Finalidade |
|---|---|
| `penMinWidth` | Largura mínima do traço |
| `penMaxWidth` | Largura máxima do traço |
| `penColor` | Cor usada no desenho em bitmap |
| `velocityFilterWeight` | Peso do filtro de velocidade |
| `clearOnDoubleClick` | Limpa ao detectar duplo toque |

A classe também expõe métodos para configurar cor e larguras, limpar e consultar o estado vazio, instalar `OnSignedListener`, recuperar a lista de pontos, restaurar uma bitmap e obter a assinatura como bitmap ou SVG.

`getTransparentSignatureBitmap()` retorna a bitmap transparente na cor efetiva do desenho; a variante com `trimBlankSpace=true` pode retornar `null` quando não há traço. `getSignatureBitmap()` produz a imagem para documentos, sempre com fundo branco e escrita preta. `getSignatureSvg()` serializa caminhos SVG na cor efetiva do desenho.

O estado visual é salvo/restaurado pelo mecanismo de estado da View. Não foi encontrada gravação permanente dos dados da assinatura.

## 6. Fluxo principal

1. O consumidor declara `SignaturePad` em uma tela Android.
2. A View recebe eventos de toque e calcula curvas Bézier com largura de traço ajustada pela velocidade.
3. O desenho é mantido em memória como bitmap; os caminhos correspondentes são mantidos para exportação SVG.
4. O consumidor consulta o estado/eventos e solicita a bitmap ou o SVG pelos métodos da View.
5. O app de demonstração exibe a bitmap retornada; não a grava em armazenamento.

## 7. Estrutura relevante

```text
app/
  src/main/java/br/com/signature/MainActivity.java
  src/main/res/layout/activity_main.xml
signature/
  src/main/java/br/com/signature/SignaturePad.java
  src/main/java/br/com/signature/utils/
  src/main/java/br/com/signature/view/
  src/main/res/values/attrs.xml
docs/
```

## 8. Dependências e comunicação

O app declara `implementation project(':signature')`. A biblioteca usa dependências AndroidX/Material e declara a biblioteca base de Data Binding; `SignaturePadBindingAdapter` fornece adaptadores para os eventos de início, assinatura e limpeza.

Não foram encontrados contratos HTTP, banco de dados, mensageria ou chamadas de serviço remoto. Não há camadas de domínio, aplicação, persistência ou backend no estado atual; o modelo genérico dessas camadas não se aplica à estrutura presente.

## 9. Distribuição e decisões registradas

O build da biblioteca aplica `maven-publish` e declara publicação do componente `release` como `com.github.Concyline.Signature:signature:<version>`. O `jitpack.yml` seleciona OpenJDK 17 e chama a tarefa de publicação do módulo `:signature`. A publicação Maven local foi validada; o sucesso remoto de uma nova tag ainda não foi confirmado.

Não foram encontrados registros separados de decisões arquiteturais (ADRs). O repositório não documenta política de compatibilidade binária/API nem estratégia de versionamento da biblioteca além dos valores configurados no build.

## 10. Testes e validação

Há testes de exemplo para soma e identificação do pacote do app; eles não cobrem o comportamento de desenho, limpeza ou exportação da biblioteca. Os comandos Gradle e os limites dos testes estão descritos em [`SETUP.md`](./SETUP.md).

## 11. Pontos sem definição no repositório

- URL oficial do repositório para clonagem.
- Sistemas operacionais e versões de Android Studio oficialmente suportados.
- Processo de release/publicação, repositório Maven de destino e responsáveis.
- Política de compatibilidade e suporte da API pública.
- Política de privacidade/retenção caso um consumidor persista ou transmita assinaturas.
- Requisitos funcionais além do propósito confirmado da biblioteca.
