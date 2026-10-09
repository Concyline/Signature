# Build e Distribuição

## 1. Estado atual

O repositório contém uma biblioteca Android (`:signature`) e um app demonstrativo (`:app`). Não há documentação ou configuração suficiente para afirmar que exista um processo oficial de implantação, publicação ou release.

Como se trata de uma biblioteca cliente Android, o código observado não descreve servidor ou ambiente de produção. Consumidores podem compilar localmente usando o projeto Gradle, mas o fluxo oficial de distribuição permanece **pendente de confirmação**.

## 2. Artefatos configurados

- O módulo `:app` possui build type `release`; `minifyEnabled` está desativado.
- O módulo `:signature` possui build type `release`; `minifyEnabled` está desativado.
- O build da biblioteca publica o componente release com coordenadas JitPack `com.github.Concyline.Signature:signature:<tag>`.
- `jitpack.yml` seleciona OpenJDK 17, declara `/build` como diretório Git seguro no container de build e publica a tarefa Maven local de `:signature`.
- A existência dessa configuração não comprova que uma tag tenha sido publicada com sucesso.

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

## 4. JitPack

O comando de instalação customizado do JitPack é:

```text
./gradlew -Pgroup=com.github.Concyline.Signature -Pversion=${VERSION} :signature:publishReleasePublicationToMavenLocal --console=plain
```

O wrapper está fixado em Gradle 9.6.0, requisito mínimo do AGP 9.4.1. O build local confirmou que esse comando publica o AAR e o POM em Maven Local com as coordenadas esperadas. Para consumidores, a dependência é `com.github.Concyline.Signature:signature:<tag>`.

A tag `1.0.3` já existia antes desta correção; as alterações locais não mudam uma tag já criada. A correção só será usada pelo JitPack depois que os arquivos forem enviados ao GitHub e uma nova tag for criada para o commit corrigido. Não mova tags existentes sem aprovação explícita.

## 5. Ambientes e rollback

Não há implantação de servidor. Cada nova publicação deve usar uma nova tag Git; não há procedimento documentado para retirar um artefato de uma tag já construída.
