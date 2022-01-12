package exam03;

import java.lang.reflect.InvocationTargetException;

/**
 * 動作チェック用のクラスです、受験者はこのファイルはいじらないでください
 * 実行することで、動作を見ることができます。
 * ただし、指定のクラスができていないとチェックが通りません。
 * @author densuke
 *
 */
public class Check {

	public static void main(String[] args) {
		System.out.println("問題3チェック *正解であることを保証するものではありません* ");
		try {
			// インスタンス生成
			var klass = Class.forName("exam03.Ex3");
			var cst = klass.getDeclaredConstructor();
			var obj = cst.newInstance();
			try {
				// フィールドを取得して値を取得
				var magicField = klass.getField("magicNum");
				int magic = magicField.getInt(obj);
				System.out.printf("magic -> %d%n", magic);

				// メソッドを取得して結果を取得
				var sumMethod = klass.getMethod("sum", int.class, int.class, int.class);
				var isHogeMedhod = klass.getMethod("isHoge", String.class);
				int sum = (int) sumMethod.invoke(obj, 3, 5, 7);
				boolean isHoge1 = (boolean) isHogeMedhod.invoke(obj, "hoge");
				boolean isHoge2 = (boolean) isHogeMedhod.invoke(obj, "hOge");
				boolean isHoge3 = (boolean) isHogeMedhod.invoke(obj, "hAge");
				System.out.printf("sum(3,5,7) -> %d\nisHoge: %s %s %s\n",
						sum,
						isHoge1, isHoge2, isHoge3);

			} catch (NoSuchFieldException e) {
				System.err.println("フィールド不足が検出されました: " + e.getLocalizedMessage());
				System.exit(1);
			}
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.err.println("クラスが存在していません: " + e.getLocalizedMessage());
		} catch (NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("インスタンス生成時にエラーが生じました");
			System.err.println(e.getLocalizedMessage());
		} finally {
			System.exit(1);
		}
	}
}
