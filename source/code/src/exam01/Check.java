/**
 * @author 0H01050 神戸パンダ
 */
package exam01;

import java.lang.reflect.InvocationTargetException;

public class Check {

	public static void main(String[] args) {
		System.out.println("問題1チェック *正解であることを保証するものではありません* ");
		try {
			// インスタンス生成
			var klass = Class.forName("exam01.Ex1");
			var cst = klass.getDeclaredConstructor();
			var obj = cst.newInstance();
			try {
				// フィールドを取得して値をセット
				var dateField = klass.getField("date");
				var amountField = klass.getField("amount");
				var memoField = klass.getField("memo");
				dateField.set(obj, "20211223");
				amountField.set(obj, 1024);
				memoField.set(obj, "クリスマスプレゼント代");
				
				// セットされた値を取得して結果を出力
				String date = (String)dateField.get(obj);
				int amount = amountField.getInt(obj);
				String memo = (String)memoField.get(obj);
				System.out.printf("使用日: %s%n金額: %d%n適用: %s%n", date, amount, memo);
				
			} catch (NoSuchFieldException e) {
				System.err.println("フィールド不足が検出されました: " + e.getLocalizedMessage());
				System.exit(1);
			}
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.err.println("クラスexam01.Ex1が存在していません");			
		} catch (NoSuchMethodException | SecurityException | InstantiationException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("インスタンス生成時にエラーが生じました");
			System.err.println(e.getLocalizedMessage());
		} finally {
			System.exit(1);
		}
	}

}
