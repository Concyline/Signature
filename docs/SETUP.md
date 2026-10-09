# Configuração do Ambiente de Desenvolvimento

## 1. Escopo

Este guia descreve a configuração observável para compilar e testar os módulos Android `app` e `signature`. A URL canônica do repositório e as combinações oficialmente suportadas de sistema operacional/Android Studio não estão documentadas; os comandos abaixo pressupõem um clone local com JDK e Android SDK instalados.

## 2. Stack e pré-requisitos

| Item | Valor observado/necessário |
|---|---|
| JDK | JDK 17 ou superior compatível com Gradle 9.6.0 e Android Gradle Plugin 9.4.1; Java 11 é o nível de source/target configurado |
| Gradle | Use o wrapper incluído; versão configurada: 9.6.0 |
| Android Gradle Plugin | 9.4.1 |
| Android SDK | Plataforma API 36 para compilação |
| Android Build Tools | Versão resolvida pelo Android Gradle Plugin/SDK; não fixada diretamente nos arquivos inspecionados |
| Dispositivo/emulador | Necessário para executar testes instrumentados e abrir o app demonstrativo; nível mínimo do app: API 23 |
| Sistema operacional | Não há matriz oficial registrada. O wrapper está disponível como `gradlew` e `gradlew.bat`. |

As dependências Maven e suas versões estão declaradas em `gradle/libs.versions.toml` e nos arquivos `build.gradle`.

**JDK configurado para este ambiente:** Android Studio usa `#GRADLE_LOCAL_JAVA_HOME` em `.idea/gradle.xml`; `.gradle/config.properties` local aponta esse macro para o JBR 17.0.14 instalado em `C:\Users\concy\.jdks\jbr-17.0.14`. O arquivo de configuração local está ignorado pelo Git. Java 17 é necessário para este Gradle/AGP e também está configurado no `jitpack.yml`.

**Validação (2026-10-09):** Gradle 9.6.0 e `gradlew.bat test` foram executados com JBR 17.0.14 com sucesso.

## 3. Obter o código

Clone usando a URL fornecida pelo responsável pelo repositório. A URL canônica não está registrada nesta documentação:

```text
git clone <URL_FORNECIDA_PELO_RESPONSAVEL>
cd Signature
```

Não substitua o placeholder por uma URL presumida.

## 4. Compilar

No Windows (PowerShell):

```powershell
.\gradlew.bat assembleDebug
```

Em sistemas com shell POSIX:

```sh
./gradlew assembleDebug
```

O projeto contém os módulos `:app` e `:signature`. Para compilar apenas a biblioteca:

```text
gradlew :signature:assembleDebug
```

Use `gradlew.bat` no Windows e `./gradlew` em shell POSIX.

## 5. Testes

Testes locais:

```text
gradlew test
```

Testes instrumentados requerem dispositivo ou emulador Android conectado:

```text
gradlew connectedAndroidTest
```

Há atualmente testes de exemplo do template Android no app e na biblioteca. Eles não fornecem cobertura significativa do comportamento de desenho/exportação.

## 6. Executar o app demonstrativo

Com emulador ou dispositivo disponível:

```text
gradlew :app:installDebug
```

Também é possível abrir o projeto no Android Studio e executar a configuração do módulo `app`. O app serve como demonstração técnica da biblioteca.

## 7. Configuração local e dados sensíveis

Os arquivos do projeto não declaram variáveis de ambiente para a aplicação. `local.properties` é uma configuração local do Android SDK e não deve ser copiada para documentação nem substituída por valores específicos de uma máquina. Não registre credenciais em arquivos versionados.

## 8. Limitações conhecidas

- O runtime JDK local não é compartilhado via Git. JBR 17.0.14 validou o build neste ambiente.
- A configuração de Gradle JDK não é compartilhada via Git; cada ambiente Android Studio precisa apontar para um JDK compatível.
- O app não persiste nem transmite assinaturas.
- Não há tarefa específica de lint configurada/documentada além das tarefas padrão do Android Gradle Plugin.
