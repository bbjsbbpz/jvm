package bbjs.practice.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUnit {

	public int copy(String source_name, String dest_name, int type)
			throws IOException {
		File source_fileFile = new File(source_name);
		File dest_fileFile = new File(dest_name);
		FileInputStream sourceFileInputStream = null;
		FileOutputStream destination = null;
		byte[] buffer;
		int bytes_read;
		int result = 0;
		try {
			if (!source_fileFile.exists() || !source_fileFile.isFile()) {
				throw new RuntimeException("源文件不存在！");
			}
			if (!source_fileFile.canRead()) {
				throw new RuntimeException("源文件不能读！");
			}
			if (dest_fileFile.exists()) {
				if (dest_fileFile.isFile()) {
					if (type == 1) {// 覆盖目标文件
						dest_fileFile.delete();
						result = 1;
					} else {// 不覆盖目标文件！
						result = 2;
						return result;
					}
				} else {
					throw new RuntimeException("目标是目录不是文件！");
				}
			} else {
				File parentdir = new File(dest_fileFile.getParent());
				if (!parentdir.exists()) {
					throw new RuntimeException("目标路径不存在！");
				}
				if (!parentdir.canWrite()) {
					throw new RuntimeException("目标路径不可写！");
				}
				// 复制文件
				sourceFileInputStream = new FileInputStream(source_fileFile);
				destination = new FileOutputStream(dest_fileFile);
				buffer = new byte[1024];
				while (true) {
					bytes_read = sourceFileInputStream.read(buffer);
					if (bytes_read == -1) {
						break;
					}
					destination.write(buffer, 0, bytes_read);
				}
			}
		} finally {
			if (sourceFileInputStream != null) {
				try {
					sourceFileInputStream.close();
				} catch (final IOException e) {

				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (final IOException e) {
					// TODO: handle exception
				}
			}
			return result;
		}
	}

	public void copyDirectory(String file1, String file2) throws IOException {
		if (!new File(file2).exists()) {
			new File(file2).mkdirs();
			File[] files = new File(file1).listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[1].getName());
				if (files[i].isFile()) {
					FileInputStream inputStream = new FileInputStream(files[i]);
					FileOutputStream outputStream = new FileOutputStream(file2
							+ "/" + files[i].getName());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = inputStream.read(b)) != -1) {
						outputStream.write(b, 0, len);
					}
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				}
				if (files[i].isDirectory()) {
					copyDirectory(file1 + "/" + files[i].getName(), file2 + "/"
							+ files[i].getName());
				}
			}
		}
	}

	public void del(String filePath) throws IOException {
		File f = new File(filePath);// 定义文件路径
		// 判断是文件还是目录
		if (f.exists() && f.isDirectory()) {
			if (f.listFiles().length == 0) {
				// 若目录下没有文件则直接删除
				f.delete();
			} else {
				// 若有则把文件放进数组，判断是否有下级目录
				File[] delFile = f.listFiles();
				for (int j = 0; j < delFile.length; j++) {
					if (delFile[j].isDirectory()) {
						// 递归调用del方法并取得子目录路径
						del(delFile[j].getAbsolutePath());
					}
					delFile[j].delete();// 删除文件
				}
			}
			del(filePath);// 递归调用
		}
	}
}
