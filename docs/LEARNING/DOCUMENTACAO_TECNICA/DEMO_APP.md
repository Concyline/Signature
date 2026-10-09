# Aplicativo Demonstrativo

**Status:** `IMPLEMENTED`  
**Última atualização:** `2026-10-09`  
**Referência:** estado do código no repositório

## 1. Objetivo

Demonstrar a integração da biblioteca `:signature` em um app Android simples. O app é demonstração técnica, conforme escopo confirmado pelo responsável.

## 2. Responsabilidades e limites

**Inclui:** abrir a tela principal, exibir a área de desenho, limpar a assinatura e exibir em um `ImageView` a bitmap retornada pela biblioteca.

**Não inclui:** persistência em arquivo ou banco, envio/compartilhamento, autenticação, backend ou fluxo de negócio. O botão “Save” atualmente apenas atualiza a imagem exibida na tela.

## 3. Localização

- `app/src/main/java/br/com/signature/MainActivity.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/AndroidManifest.xml`
- Configuração Gradle em `app/build.gradle`

## 4. Fluxo

`MainActivity` configura `EdgeToEdge`, carrega o layout, define a cor preta da caneta, registra os callbacks de assinatura e conecta os botões `clear` e `save`. O botão de limpeza chama `SignaturePad.clear()`. O botão de demonstração obtém `getSignatureBitmap()` e aplica o resultado ao `ImageView`.

## 5. Configuração e dependências

O app usa namespace/application ID `br.com.signature`, min SDK 23, target/compile SDK 36 e Java 11. Depende do módulo local `:signature`, AppCompat, Material, Activity, ConstraintLayout e bibliotecas de teste AndroidX/JUnit.

## 6. Testes e limitações

Os testes presentes verificam uma soma de exemplo e o application ID; não há teste de interface nem do fluxo da assinatura. Os textos “Clear” e “Save” estão diretamente no XML e não estão atualmente em recursos localizados.

Consulte [`SETUP.md`](../../SETUP.md) para compilação e execução. O app não deve ser tratado como especificação de UI de produto.
