package exam02;

import java.lang.reflect.InvocationTargetException;

/**
 * 動作チェック用のクラスです、受験者はこのファイルはいじらないでください
 * 実行することで、動作を見ることができます
 * ※ 何やってるのか気になる方は、受験後に眺めてみると参考になるかもしれませんよ
 * @author densuke
 *
 */
public class Check {

	public static void main(String[] args) {
		System.out.println("問題2チェック *正解であることを保証するものではありません* ");
		try {
			// インスタンス生成
			var klass = Class.forName("exam02.Ex2");
			var cst = klass.getDeclaredConstructor();
			var obj = cst.newInstance();
			try {
				// フィールドを取得してインスタンスの持つ値を取得
				var ageField = klass.getField("age");
				var nameField = klass.getField("name");
				int age = ageField.getInt(obj);
				String name = (String) nameField.get(obj);
				System.out.printf("name: %s(check: %s)%nage: %d%n",
							name,
							name == "John Smith",
							age);

			} catch (NoSuchFieldException e) { // フィールドが存在しないときの例外処理
				System.err.println("フィールド不足が検出されました: " + e.getLocalizedMessage());
				System.exit(1);
			}
			System.exit(0);
		} catch (ClassNotFoundException e) { // クラスがない時
			System.err.println("クラスが存在していません: " + e.getLocalizedMessage());
		} catch (NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// クラスはあったけどインスタンス生成時にエラーがあった時
			System.err.println("インスタンス生成時にエラーが生じました");
			System.err.println(e.getLocalizedMessage());
		} finally {
			System.exit(1);
		}
	}

}
