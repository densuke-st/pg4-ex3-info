package exam00;

/**
 * 問題0: 出席番号と氏名の登録
 * クラスExにおけるidとnameに対し、あなたの出席番号と氏名を設定してください。
 * ただし、以下に留意すること
 * 
 * - 出席番号は半角英数7桁、2桁目の英語は大文字とすること
 * - 氏名に全角の空白を入れないこと
 * 
 * なお、簡易チェックツールとしてCheckを用意しているため、
 * 書き換え後にCheckクラスを実行することで確認できるようにしている。
 * ただし、出席番号や氏名の正当性までは確認しないため、
 * 特に出席番号の書き間違えをしないようにすること。
 * (採点不可能となります)
 * 
 * @author densuke
 *
 */
public class Ex {
	// 出席番号(要変更)
	private String id = "0H09050";
	// 氏名(要変更、全角空白はNG)
	private String name = "神戸パンダ";
	
	// 以下は変更禁止
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
