package bbjs.practice.io;

import java.io.IOException;

public interface Operation {
	public void copy(String src,String tgt) throws IOException;
	public void copyDirectory(String src,String tgt);
	public void delete(String filePath);
}
