package bbjs.practice.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import bbjs.practice.StringReplacer;
import bbjs.practice.log.MyLogHander;

public class FileOperator {

	protected Logger log = Logger.getLogger(StringReplacer.class.toString());

	public void initLog() throws IOException {
		FileHandler fileHandler = new FileHandler("D:\\JavaStudy\\practice\\StringReplacer\\log\\replacer.log");
		fileHandler.setLevel(Level.INFO);
		fileHandler.setFormatter(new MyLogHander());
		log.addHandler(fileHandler);
	}
	
	public void copy(String src, String tgt) throws IOException {
		// TODO Auto-generated method stub

		(new File(tgt)).mkdirs();
		File[] files = (new File(src)).listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				FileInputStream input = new FileInputStream(file);
				String outputFile = tgt + File.separator + file.getName();
				FileOutputStream output = new FileOutputStream(outputFile);
				System.out.println("copying " + file.getAbsolutePath() + " -> "
						+ outputFile);
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			} else {
				System.out.println("Copying sub folder...");
				copy(src + File.separator + file.getName(), tgt
						+ File.separator + file.getName());
			}
		}

	}

	public String fileToString(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line + "\r\n");
		}
		br.close();
		return sb.toString();
	}

	public String listToString(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String line : list) {
			sb.append(line + "\r\n");
		}
		return sb.toString();
	}

	public ArrayList<String> stringToList(String content) {
		ArrayList<String> list = new ArrayList<String>();
		int start = 0;
		String line = "";
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == '\n') {
				line = content.substring(start, i);
				start = i;
				list.add(line);
			}
		}
		return list;
	}

	public ArrayList<String> fileToList(File file) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();
		return list;
	}

	public void writeTo(String content, File file) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(content);
		fw.flush();
		fw.close();
	}

	public static void main(String[] args) throws IOException {
		String src = "D:\\JavaStudy\\practice\\StringReplacer\\src";
		String tgt = "D:\\JavaStudy\\practice\\StringReplacer\\tgtCopy";
		FileOperator app = new FileOperator();
		//app.copy(src, tgt);
		System.out.println(app.setOutput("StringReplacer"));
	}

	public String setOutput(String app){
		StringBuilder sb = new StringBuilder("D:\\JavaStudy\\practice\\");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dd = sdf.format(date);
		sb.append(app + "\\output\\" + dd);
		return sb.toString();
	}

}
