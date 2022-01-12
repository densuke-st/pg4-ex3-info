.. _exam02:

==============
問題2(exam2)
==============

問題2は、クラスを実際に作るところからとなっています。なお、 **正解(テストの通る)コード全体は敢えて記載しておりません** 。
既にやっていることなので、書いても答えを移して動いて「あぁ動いた」で満足されても困るからです。
きちんと自分で書いて、 :code:`Check` クラスが通るかぐらいは確認してみましょう。どうしてもわからないときは、授業担当に質問を投げてみてください。

.. literalinclude:: code/src/exam02/Mondai.md
    :language: markdown

問題文に記されているように、 :code:`exam02` パッケージ空間のクラス :code:`Ex2` として作成すればOKです。
生成されるクラス(:code:`exam02.Ex2`)は、結果として以下のような書き始めになります。

.. literalinclude:: code/src/exam02/Ex2.java
    :language: java
    :lines: 1-3
    :caption: :code:`exam02.Ex2` (冒頭のみ)
    :linenos:

:code:`public` のフィールドは、指示に従い作成しておけばいいので、以下のようになります。

.. literalinclude:: code/src/exam02/Ex2.java
    :language: java
    :lines: 3-6
    :caption: :code:`exam02.Ex2` (初期値入りフィールドの追加)
    :linenos:
    :lineno-start: 3

フィールドの初期値
=============================

Javaではフィールドに初期値を与えておくことができます。記述上、普通に代入すればOKです。
フィールドを初期化する方法については、大きく2つ、登場します。

- フィールド宣言時に初期値を書き込む(今回の方法)
- コンストラクタで代入する

いずれも行わなかった場合、それぞれの型における初期値が使われます。

- 基本型(:code:`char,int,float,double` 等、型名が小文字のもの)は0に相当するもの
- クラス(:code:`String` 等、大文字で始まるもの)や配列は参照のため :code:`null`

.. _exam02-constructor:

コンストラクタ
=====================

コンストラクタは、インスタンス生成時に自動的に呼び出されるメソッドです。この機能を用いると、初期化を実行時に遅延できます。

.. code-block:: java
    :caption: コンストラクタの例(引数なし)
    :emphasize-lines: 1,5-7

    public class Fuga {
        public int x;
        public int y;

        public Fuga() { // クラスと同名かつ戻り値指定がない→コンストラクタ
            x = 0; y = 0; // インスタンス上にフィールドx,yは存在するので代入可能
        }
    }

また、コンストラクタは引数を受け取ることもできるので、受け取った値を使って初期化することも可能です。

.. code-block:: java
    :caption: コンストラクタの例(引数あり)
    :emphasize-lines: 1,5-7

    public class Fuga {
        public int x;
        public int y;

        public Fuga(int a, int b) { // 引数つきコンストラクタ
            x = a; y = b;
        }
    }

さらに、 **オーバーロードも可能** なので、引数有り、無しを両方指定することも可能です。

.. code-block:: java
    :caption: コンストラクタの例(複数)
    :emphasize-lines: 1,5-7,9-11

    public class Fuga {
        public int x;
        public int y;

        public Fuga() { // 引数がなければ(0,0)で初期化
            x = 0; y = 0;
        }

        public Fuga(int a, int b) { // 引数があれば(a,b)で初期化
            x = a; y = b;
        }
    }

なお今回の問題では、 **コンストラクタを使って初期化していても問題は起きません** ので、(代入する値を間違えていなければ) **正解となります** 。