package bbjs.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import bbjs.practice.log.MyLogHander;
import bbjs.practice.io.FileOperator;

public class StringReplacer extends FileOperator {
	private File srcFile;
	private File tgtFile;
	private File cfgFile;

	private class KeyValue {
		private String key;
		private String value;

		// Pattern pt = Pattern.compile(key);
		public KeyValue(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	private ArrayList<KeyValue> config = new ArrayList<KeyValue>();

	

	public StringReplacer(File srcFile, File cfgFile) {
		super();
		this.srcFile = srcFile;
		this.cfgFile = cfgFile;
	}

	public void process() throws IOException{

		this.tgtFile = new File(this.setOutput("StringReplacer"));
		if (srcFile.isDirectory()) {
			super.initLog();
			this.fillConfig();
			processFile(srcFile.getAbsolutePath(), tgtFile.getAbsolutePath());
		}
	}

	public void processFile(String src, String tgt) throws IOException {
		File tgtDir = new File(tgt);
		// if(!tgtDir.isDirectory()||!tgtDir.exists()){
		tgtDir.mkdirs();
		// }
		File[] files = new File(src).listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				String fileContent = fileToString(file);
				String replacedContent = this.replaceSingleLine(fileContent);
				File singleFile = new File(tgt + File.separator
						+ file.getName());
				log.info(file.getAbsolutePath() + " -> "
						+ singleFile.getAbsolutePath());
				if (singleFile.exists()) {
					singleFile.delete();
				}
				writeTo(replacedContent, singleFile);
			} else {
				processFile(src + File.separator + file.getName(), tgt
						+ File.separator + file.getName());
			}
		}
	}

	public void fillConfig(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			String key = line.split(",")[0];
			String value = line.split(",")[1];
			log.info("config adding " + key + "," + value);
			config.add(new KeyValue(key, value));
		}
	}

	public void fillConfig() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(cfgFile));
		String line = "";
		while ((line = br.readLine()) != null) {
			String key = line.split(",")[0];
			String value = line.split(",")[1];
			config.add(new KeyValue(key, value));
		}
	}

	public String replaceSingleLine(String line) {
		String replacedLine = line;
		for (KeyValue kv : config) {
			// if(kv.pt.matcher(line).find()){
			replacedLine = replacedLine.replaceAll(kv.key, kv.value);
			// System.out.println(replacedLine);
			// }
		}
		return replacedLine;
	}

	public static void main(String[] args) throws IOException {
		File file = new File(
				"D:\\JavaStudy\\practice\\StringReplacer\\output.txt");

		File srcFile = new File(
				"D:\\JavaStudy\\practice\\StringReplacer\\input");
		File tgtFile = new File(
				"D:\\JavaStudy\\practice\\StringReplacer\\tgtReplacer");
		File cfgFile = new File(
				"D:\\JavaStudy\\practice\\StringReplacer\\config.txt");
		StringReplacer app = new StringReplacer(srcFile, cfgFile);
		app.process();
		// app.fillConfig(cfgFile);

		// String content = "xxx@@@YYY##";
		// content = app.replaceSingleLine(content);
		// System.out.println(content);
	}

}
