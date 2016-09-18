package bbjs.practice.io;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileInterfaceImplTest {
	
	private FileInterface app;

	@Before	
	public void beforeClass(){
		app = new FileInterfaceImpl();
	}
	
	@Test
	public void testCopy() {
		String srcPath = "D:\\test\\a.txt";
		String tgtPath = "D:\\test\\copyTo";
		app.copy(srcPath, tgtPath);
	}

	@Test
	public void testCopyDirctory() {
		String srcPath = "D:\\java_app";
		String tgtPath = "D:\\test";
		app.copyDirctory(srcPath, tgtPath);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFileToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplace() {
		fail("Not yet implemented");
	}

}
