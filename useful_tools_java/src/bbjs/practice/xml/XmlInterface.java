package bbjs.practice.xml;

public interface XmlInterface {
	/** 
     * ����XML�ĵ� 
     * @param fileName �ļ�ȫ·������ 
     */
     public void createXml(String fileName); 
     /** 
     * ����XML�ĵ� 
     * @param fileName �ļ�ȫ·������ 
     */
     public void parserXml(String fileName); 
     
     public void sortXml(String fileName);
     
     public void compareXml(String fileName1, String fileName2);
     
     public void envConvert(String srcPath, String tgtPath, String envId);
}
