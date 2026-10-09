# Build e Distribuição

## 1. Estado atual

O repositório contém uma biblioteca Android (`:signature`) e um app demonstrativo (`:app`). Não há documentação ou configuração suficiente para afirmar que exista um processo oficial de implantação, publicação ou release.

Como se trata de uma biblioteca cliente Android, o código observado não descreve servidor ou ambiente de produção. Consumidores podem compilar localmente usando o projeto Gradle, mas o fluxo oficial de distribuição permanece **pendente de confirmação**.

## 2. Artefatos configurados

- O módulo `:app` possui build type `release`; `minifyEnabled` está desativado.
- O módulo `:signature` possui build type `release`; `minifyEnabled` está desativado.
- O build da biblioteca configura uma publicação Maven com coordenadas `com.github.Concyline:Signature:1.0.2` e associa o AAR de release.
- Não foi identificada configuração de repositório Maven de destino, publicação autenticada, assinatura ou automação CI/CD. As coordenadas configuradas, isoladamente, não comprovam publicação disponível.

## 3. Build local de release

Com JDK e Android SDK configurados, a tarefa Gradle declarada para gerar o AAR da biblioteca é:

```text
gradlew :signature:bundleReleaseAar
```

Use `gradlew.bat` no Windows ou `./gradlew` em sistemas POSIX. O caminho de saída configurado é:

```text
signature/build/outputs/aar/signature-release.aar
```

Este comando gera um artefato local; não o publica.

## 4. Processo de publicação

**Pendente:** responsável do projeto deve confirmar o repositório de destino, mecanismo de autenticação, versionamento, assinatura, critérios de aprovação, publicação e procedimento de verificação. Não adicione credenciais ao repositório.

Até essa definição, não execute publicação ou release com base apenas no bloco `publishing` do Gradle.

## 5. Ambientes e rollback

Não foram identificados ambientes de desenvolvimento, homologação ou produção para implantação de servidor, nem branches de release definidos nos arquivos consultados. Não há procedimento oficial de rollback do artefato. A atualização ou retirada de versões publicadas depende da confirmação do processo de distribuição.
