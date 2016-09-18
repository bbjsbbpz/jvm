package bbjs.practice.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import bbjs.practice.object.JobElement;
import bbjs.practice.util.StringHelper;

public class Dom4jXmlImpl implements XmlInterface {

	@Override
	public void createXml(String fileName) {
		// TODO Auto-generated method stub
		Document document = DocumentHelper.createDocument();
		Element table = document.addElement("TABLE");
		table.addAttribute("TABLENAME", "PFRM##B31002");
		table.addAttribute("userdaily", "userdaily");
		for (int i = 110; i > 100; i--) {
			Element job = table.addElement("JOB");
			job.addAttribute("JOBNAME", "PFRM##B31000" + i);
			job.addAttribute("MEMNAME", "PFRM##B31001" + i);
			job.addAttribute("ACTIVE", "YES");
		}

		XMLWriter xmlWriter = new XMLWriter();
		try {
			xmlWriter.write(document);
			OutputFormat format = new OutputFormat("    ", true);
			XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream(
					"PFRM##B31002.xml"), format);
			xmlWriter2.write(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void parserXml(String fileName) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		XmlInterface app = new Dom4jXmlImpl();
		// app.createXml("");
		// app.sortXml("");
		String srcPath = "D:\\workspace\\useful_tools_java\\xml";
		String tgtPath = "D:\\workspace\\useful_tools_java\\xmlU";
		String envId = "U";
		app.envConvert(srcPath, tgtPath, envId);
	}

	@Override
	public void sortXml(String fileName) {
		// TODO Auto-generated method stub
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new File("PFRM##B31002.xml"));
			Element table = document.getRootElement();
			List jobList = table.elements("JOB");
			List<JobElement> jobElements = new ArrayList<JobElement>();

			for (Object job : jobList) {
				Element jobNode = (Element) job;
				JobElement jobElement = new JobElement();
				jobElement.setJobName(jobNode.attributeValue("JOBNAME"));
				jobElement.setJobNode(jobNode);
				jobElements.add(jobElement);
			}
			// before sort
			System.out.println("========= before sort ===========");
			for (JobElement je : jobElements) {
				System.out.println(je);
			}
			// after sort
			System.out.println("========= after sort ===========");
			java.util.Collections.sort(jobElements);
			for (JobElement je : jobElements) {
				System.out.println(je);
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void compareXml(String fileName1, String fileName2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void envConvert(String srcPath, String tgtPath, String envId) {
		// TODO Auto-generated method stub
		if (srcPath.equals(tgtPath)) {
			throw new RuntimeException(
					"srcPath and tgtPath cannot be the same.");
		}

		File srcFile = new File(srcPath);
		File tgtFile = new File(tgtPath);

		if (!srcFile.isDirectory()) {
			throw new RuntimeException(srcPath + " is not a valid path.");
		}

		if (!tgtFile.isDirectory()) {
			if (!tgtFile.mkdirs()) {
				throw new RuntimeException(tgtPath + " is not a valid path.");
			}
		}

		File[] files = srcFile.listFiles();
		for (File file : files) {
			String newTgtPath = tgtPath + File.separator
					+ StringHelper.insertString(file.getName(), envId, 4);
			tgtFile = new File(newTgtPath);
			envConvertFile(file, tgtFile, envId);
		}

	}

	public List<Attribute> getOtherAttributes(Element element, String attrName) {
		List<Attribute> otherAttributes = element.attributes();
		// System.out.println("all attributes count: "+otherAttributes.size());
		for (Attribute attr : otherAttributes) {
			if (attr.getName().equals(attrName)) {
				otherAttributes.remove(attr);
			}
		}
		// System.out.println("other attributes count: "+otherAttributes.size());
		return otherAttributes;
	}

	public void envConvertFile(File srcFile, File tgtFile, String envId) {
		SAXReader saxReader = new SAXReader();
		try {
			Document srcDocument = saxReader.read(srcFile);
			Document tgtDocument = DocumentHelper.createDocument();
			Element srcRootTable = srcDocument.getRootElement();
			String tableAttr = "TABLENAME";
			String jobAttr = "JOBNAME";
			int pos = 4;
			String srcTableName = srcRootTable.attributeValue(tableAttr);
			String tgtTableName = StringHelper.insertString(srcTableName,
					envId, pos);
			Element tgtTable = tgtDocument.addElement("TABLE");
			tgtTable.addAttribute(tableAttr, tgtTableName);
			List<Attribute> otherAttributes = getOtherAttributes(srcRootTable,
					tableAttr);
			for (Attribute attr : otherAttributes) {
				System.out.println(attr.getData());
				tgtTable.addAttribute(attr.getName(), attr.getValue());
				// tgtTable.add(attr);
			}

			List<Element> srcJobList = srcRootTable.elements("JOB");
			for (Element jobElement : srcJobList) {
				String srcJobName = jobElement.attributeValue(jobAttr);
				String tgtJobName = StringHelper.insertString(srcJobName,
						envId, pos);
				otherAttributes = getOtherAttributes(jobElement, jobAttr);
				Element tgtJob = tgtTable.addElement("JOB");
				tgtJob.addAttribute(jobAttr, tgtJobName);
				for (Attribute attr : otherAttributes) {
					// tgtJob.add(attr);
					tgtJob.addAttribute(attr.getName(), attr.getValue());
				}
			}

			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(tgtFile));
			xmlWriter.write(tgtDocument);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
