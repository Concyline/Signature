# Captura e Exportação de Assinatura

**Status:** `IMPLEMENTED — comportamento observado no código`  
**Última atualização:** `2026-10-09`  
**Módulo:** `:signature`

## 1. Objetivo

Permitir que uma aplicação Android incorpore uma área de desenho manual e obtenha o traço capturado em bitmap ou SVG.

## 2. Escopo observado

- Captura de entrada por toque em `SignaturePad`.
- Suavização por curvas Bézier e largura adaptada à velocidade do gesto.
- Configuração da cor e larguras mínima/máxima do traço.
- Preservação da cor configurada em modo claro e uso de linha branca em modo noturno, incluindo traços já existentes e saída SVG.
- Estado vazio/assinado, callbacks e limpeza manual; limpeza por duplo toque é opcional.
- Saída em bitmap transparente ou composta sobre fundo branco.
- Opção de cortar espaços vazios na bitmap transparente.
- Saída serializada em SVG.

## 3. Fora do escopo observado

O projeto não salva assinaturas em armazenamento, não as envia a serviços, não associa uma assinatura a uma identidade e não implementa assinatura digital criptográfica ou validação jurídica. Não assumir esses comportamentos.

## 4. Interface técnica

O contrato está exposto pela View `br.com.signature.SignaturePad` e seus atributos XML descritos em [`SIGNATURE_LIBRARY.md`](../LEARNING/DOCUMENTACAO_TECNICA/SIGNATURE_LIBRARY.md). O SVG usa a cor efetiva da caneta. `getSignatureBitmap()` mantém fundo branco; em superfícies escuras, use `getTransparentSignatureBitmap()`. O corte de bitmap pode retornar `null` quando não há conteúdo.

## 5. Validação e pendências

Testes unitários cobrem escolha da cor para dia/noite e cor do SVG. Testes automatizados de desenho, limpeza, saída vazia e recoloração de bitmap em dispositivo ainda não foram identificados. Critérios de aceitação de produto, formatos de arquivo finais e política de retenção dependem de confirmação do responsável.
