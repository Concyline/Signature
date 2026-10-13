# SignaturePad

**Status:** `IMPLEMENTED`  
**Última atualização:** `2026-10-09`  
**Categoria:** `Componente Android reutilizável`  
**Módulo consumidor observado:** `:app`

## 1. Objetivo

Disponibilizar uma View customizada para captura manual de traços e exportação da assinatura desenhada.

## 2. Responsabilidades

**Deve fazer:** receber desenho por toque, desenhar em bitmap, acompanhar vazio/assinado, enviar callbacks e expor as saídas bitmap/SVG públicas.

**Não deve ser tratado como:** serviço de persistência, validação de identidade ou assinatura digital criptográfica. Essas responsabilidades não estão implementadas no código observado.

## 3. Localização

- `signature/src/main/java/br/com/signature/SignaturePad.java`
- `signature/src/main/res/values/attrs.xml`
- Utilitários em `signature/src/main/java/br/com/signature/utils/`

## 4. Contrato de uso observado

Inclua `br.com.signature.SignaturePad` em uma tela XML ou crie a View com `Context` e `AttributeSet`. Atributos suportados: `penMinWidth`, `penMaxWidth`, `penColor`, `velocityFilterWeight` e `clearOnDoubleClick`. O modo claro preserva a cor configurada; no modo noturno a linha é branca para manter contraste. Uma mudança de modo recolore os traços já desenhados, e o SVG usa a cor efetiva do componente.

Métodos relevantes incluem `clear()`, `isEmpty()`, `setOnSignedListener(...)`, `getSignatureBitmap()`, `getTransparentSignatureBitmap(...)`, `getSignatureSvg()` e `setSignatureBitmap(...)`. Os detalhes e limitações estão em [`SIGNATURE_LIBRARY.md`](../DOCUMENTACAO_TECNICA/SIGNATURE_LIBRARY.md).

## 5. Exemplo mínimo

```xml
<br.com.signature.SignaturePad
    android:id="@+id/signature_pad"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:penColor="@android:color/black" />
```

O layout precisa declarar `xmlns:app="http://schemas.android.com/apk/res-auto"` para atributos `app:`. Consulte o layout da demonstração para exemplo existente.

## 6. Restrições

`getSignatureBitmap()` retorna uma imagem para documentos, sempre com fundo branco e escrita preta, independentemente do tema. Use `getTransparentSignatureBitmap()` para preservar a cor efetiva do traço, inclusive a branca no modo noturno, por exemplo ao exibir sobre uma superfície escura. A variante transparente com corte pode retornar `null` para uma área vazia.
