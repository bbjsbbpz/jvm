package bbjs.practice.io;

public interface FileInterface {
	public void copy(String srcPath, String tgtPath);
	
	public void copyDirctory(String srcPath, String tgtPath);

	public void delete(String srcPath);

	public void remove(String srcPath, String tgtPath);

	public void writeTo(String content, String tgtPath);
	
	public String fileToString(String srcPath);
	
	public void replace(String srcPath, String tgtPath, String configPath);
}
