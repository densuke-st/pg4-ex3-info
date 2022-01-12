package exam00;

/**
 * 動作チェック用のクラスです、受験者はこのファイルはいじらないでください
 * 実行することで、動作を見ることができます
 * @author densuke
 *
 */
public class Check {

	public static void main(String[] args) {
		Ex e = new Ex();
		System.out.println("問題0 簡易テスト");
		System.out.printf("出席番号: %s%n氏名: %s%n", e.getId(), e.getName());
		
		if(e.getId() == "0H09050" || e.getName() == "神戸パンダ") {
			System.err.println("出席番号もしくは氏名が初期状態のままのようです、このままだと採点対象外となります");
		} else {
			System.out.println("出席番号・氏名に間違いありませんか? 間違っている場合は採点されない恐れがあります");
		}
		
		if(e.getName().contains("　")) {
			System.err.println("氏名に全角空白が含まれています、採点対象外となりますので訂正してください");
		}
	}

}
