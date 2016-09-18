package bbjs.practice.xml;

public interface XmlInterface {
	/** 
     * 建立XML文档 
     * @param fileName 文件全路径名称 
     */
     public void createXml(String fileName); 
     /** 
     * 解析XML文档 
     * @param fileName 文件全路径名称 
     */
     public void parserXml(String fileName); 
     
     public void sortXml(String fileName);
     
     public void compareXml(String fileName1, String fileName2);
     
     public void envConvert(String srcPath, String tgtPath, String envId);
}
