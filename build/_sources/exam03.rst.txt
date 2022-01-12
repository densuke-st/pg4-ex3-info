.. _exam03:

==============
問題3(exam3)
==============

問題3も、 **正解(テストの通る)コード全体は敢えて記載しておりません** 。
既にやっていることなので、書いても答えを移して動いて「あぁ動いた」で満足されても困るからです。
きちんと自分で書いて、 :code:`Check` クラスが通るかぐらいは確認してみましょう。どうしてもわからないときは、授業担当に質問を投げてみてください。

.. literalinclude:: code/src/exam03/Mondai.md
    :language: markdown

問題文に記されているように、 :code:`exam03` パッケージ空間のクラス :code:`Ex3` として作成すればOKです。
ただ、 :code:`exam03.Ex3` の仕様は、別サイトにあるJavaDocに基づいたものになっています。

- `Ex3 <https://densuke-st.github.io/pg4-ex3doc/doc/exam03/Ex3.html>`_

これは、多くの言語で用いられている **コードからのドキュメント自動生成** を用いたもので、Javaの場合は標準化されたものとして **JavaDoc** というものがあります。このドキュメントはJavaDocを用いたものとなっています。
フィールドやメソッドの形式はコードから抽出、説明テキストは直前に存在するJavaDoc用コメントから生成されます。

この中で、フィールドとしては :code:`magicNum` が必要とされています。

.. literalinclude:: code/src/exam03/Ex3.java
    :language: java
    :emphasize-lines: 2
    :lines: 3-5

.. note::

    もちろん :ref:`コンストラクタを使用pwd<exam02-constructor>` してもかまいません。

コンストラクタについては「 `コンストラクタの詳細 <https://densuke-st.github.io/pg4-ex3doc/doc/exam03/Ex3.html#%3Cinit%3E()>`_ 」というものが出ていますが、まったく内容はありませんので、あっても無くても支障はありません。よってここでは用意しない形で進めておきます。

メソッドの実装
========================

この問題では、メソッドとして :code:`sum` が規定されています(→ `sum() <https://densuke-st.github.io/pg4-ex3doc/doc/exam03/Ex3.html#sum(int,int,int)>`_  、 `isHoge() <https://densuke-st.github.io/pg4-ex3doc/doc/exam03/Ex3.html#isHoge(java.lang.String)>`_)。
各メソッドの定義もきちんと書かれており(:code:`public` となっていることにも注意)、仕様を満たすように記述すればいいでしょう。

.. literalinclude:: code/src/exam03/Ex3.java
    :language: java
    :lineno-start: 6
    :lines: 6-12