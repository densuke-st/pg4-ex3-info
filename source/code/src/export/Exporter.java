package export;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import exam00.Ex;


/**
 * 提出アーカイブ作成クラス: exam01,02,03に不備があると「必要なプロジェクトにエラー」とでることがあります
 * が、そのまま「続行」してもらって大丈夫です。
 * 
 * @author densuke
 *
 */
public class Exporter {

	static final String base = "exam-20211220";
	static final long limitTime = 1641451800; // 2022-01-06 15:50:00

	public static void main(String[] args) {
		System.out.println("解答エクスポートツール: 現時点での解答をアーカイブします");
		Ex e = new Ex();
		System.out.printf("出席番号: %s%n氏名: %s%n", e.getId(), e.getName());
		if(e.getId().equals("0H09050") || e.getName() == "神戸パンダ") {
			System.err.println("出席番号・氏名が初期値から変更されていない可能性があります");
			System.err.println("提出用ファイルの作成をキャンセルしました。");
			System.err.println("exam00.Exクラスを再チェックしましょう");
			System.exit(1);
		}
		if(e.getName().contains("　")) {
			System.err.println("氏名に全角空白が入っております、提出ファイルの作成をキャンセルしました。");
			System.exit(1);
		}

		Long epoch = (new Date()).getTime();
		if(epoch >= limitTime*1000) {
			System.err.println("制限時間を超えたので提出ファイルの作成をキャンセルします。");
			System.out.printf("now:%d limit:%d%n", epoch, limitTime);
			System.exit(1);
		}
		System.out.printf("時刻情報 now:%d limit:%d%n", epoch, limitTime);
		String outfile = String.format("%s-%s-%d.tar.gz", base, e.getId(), epoch);
		System.out.println("出力ファイル名: " + outfile);
		Path base = Paths.get(System.getProperty("user.dir"));
		String sep = System.getProperty("file.separator");
		Path dest = Paths.get(base + sep + outfile);
		System.out.println(dest);
		Path dir = Paths.get(base + sep + "src");

		// Apache Commons Compressを用いてのアーカイブ作成
		try (OutputStream fo = Files.newOutputStream(dest);
				OutputStream gzo = new GZIPOutputStream(fo);
				ArchiveOutputStream out = new TarArchiveOutputStream(gzo);
				Stream<Path> stream = Files.walk(dir)
						.filter(path -> path.toFile().getName().endsWith(".java"))
						.filter(path -> { 
							return path.toFile().getName().startsWith("Ex");})
						) {
			stream.forEach(p -> {
				try {
					ArchiveEntry entry = out.createArchiveEntry(p.toFile(),
							p.subpath(dir.getNameCount(), p.getNameCount()).toString());
					out.putArchiveEntry(entry);
					if (p.toFile().isFile()) {
						try (InputStream i = Files.newInputStream(p)) {
							IOUtils.copy(i, out);
						}
					}
					out.closeArchiveEntry();
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				}
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("作成しました、提出ファイル↑の場所をフォルダで示します");
		// OSの取得
		String os = System.getProperty("os.name").toLowerCase();
		String opencommand = "";
		// System.out.println(os);
		if(os.startsWith("windows")) {
			opencommand = "start";

		} else if (os.startsWith("mac")) {
			opencommand = "open";

		} else {
			System.out.println("OSの特定ができませんでした、自力で開いてください");
		}
		if(opencommand != "") {
			ProcessBuilder p = new ProcessBuilder(opencommand, base.toString());
			try {
				p.start();
			} catch(Exception e1) {
				e1.getStackTrace();
			}
		}
	}
}
