package bbjs.practice.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Field;

public class FileInterfaceImpl implements FileInterface {

	private String fileTimestamp;

	public void backup(File file) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		fileTimestamp = df.format(new Date());
		System.out.println("rename to " + fileTimestamp);
		file.renameTo(new File(file.getName() + "_" + fileTimestamp + ".bak"));
	}

	@Override
	public void copy(String srcPath, String tgtPath) {
		// TODO Auto-generated method stub
		if (srcPath.equals(tgtPath)) {
			throw new RuntimeException(
					"srcPath and tgtPath cannot be the same.");
		}

		long starTime = System.currentTimeMillis();
		File srcFile = new File(srcPath);
		File tgtFile = new File(tgtPath);

		if (!srcFile.exists()) {
			throw new RuntimeException(srcPath + " does not exist.");
		}

		if (!srcFile.isFile()) {
			throw new RuntimeException(srcPath + " is not a file.");
		}

		if (!srcFile.canRead()) {
			throw new RuntimeException(srcPath + " cannot read.");
		}

		if (tgtFile.isDirectory()) {
			tgtFile = new File(tgtPath + File.separator + srcFile.getName());
		} else {
			throw new RuntimeException(tgtPath + " is not a valid path.");
		}

		try {
			InputStream fis = new FileInputStream(srcFile);
			OutputStream fos = new FileOutputStream(tgtFile);
			byte[] buf = new byte[1024 * 5];
			int len;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.flush();
			fos.close();
			fis.close();
			long endTime = System.currentTimeMillis();
			long duration = endTime - starTime;
			// System.out.println("copy is runing for "+duration+" ms.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void copyDirctory(String srcPath, String tgtPath) {
		// TODO Auto-generated method stub

		if (srcPath.equals(tgtPath)) {
			throw new RuntimeException(
					"srcPath and tgtPath cannot be the same.");
		}

		File srcFile = new File(srcPath);
		File tgtFile = new File(tgtPath);

		if (!srcFile.isDirectory()) {
			throw new RuntimeException(srcPath + " is not a directory.");
		}

		if (!tgtFile.isDirectory()) {
			if (!tgtFile.mkdirs()) {
				throw new RuntimeException(tgtPath + " is not a directory.");
			}
		}

		File[] srcFiles = srcFile.listFiles();
		for (File file : srcFiles) {
			if (file.isDirectory()) {
				tgtPath = tgtPath + File.separator + file.getName();
				copyDirctory(srcPath + File.separator + file.getName(), tgtPath);

			} else {
				copy(srcPath + File.separator + file.getName(), tgtPath);
			}
		}
	}

	@Override
	public void delete(String srcPath) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String srcPath, String tgtPath) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeTo(String content, String tgtPath) {
		// TODO Auto-generated method stub
		try {
			Writer writer = new FileWriter(tgtPath, true);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String fileToString(String srcPath) {
		// TODO Auto-generated method stub
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					srcPath)));

			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}			
			br.close();
			return sb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public void replace(String srcPath, String tgtPath, String configPath) {
		// TODO Auto-generated method stub
		
	}

}
