package files;

import java.io.File;
import java.io.IOException;


public class directoryProcessing {
	public static void main(String[] args) {
		try {

			listFiles("C:\\Users\\leena\\Desktop\\Files");
			listFilesDetails("C:\\Users\\leena\\Desktop\\Files");
			renameFile("C:\\Users\\leena\\Desktop\\Files", "text", "C:\\Users\\leena\\Desktop\\Files\\newtext.txt");
			createNewFile("C:\\Users\\leena\\Desktop\\Files\\text2.txt");
			moveFile("C:\\Users\\leena\\Desktop\\Files", "text", "C:\\Users\\leena\\Desktop\\Files\\new text.txt");
			deleteFile("C:\\Users\\leena\\Desktop\\Files", "DSCN1835");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void listFiles(String folderPath) throws IOException {
		File directory = new File(folderPath);
		File directorySubFiles[] = directory.listFiles();

		for (File contents : directorySubFiles)
			System.out.println(contents.getName());
	}

	public static void listFilesDetails(String folderPath) throws IOException {
		File directory = new File(folderPath);
		File directorySubFiles[] = directory.listFiles();

		for (File contents : directorySubFiles) {

			int indexOfExt = contents.getName().indexOf(".");
			System.out.println("File name: " + contents.getName().substring(0, indexOfExt));
			System.out.println("File type: " + contents.getName().substring(indexOfExt));
			System.out.println("File size: " + contents.length());
			System.out.println();
		}
	}

	public static void renameFile(String folderPath, String file, String newFilePath) throws IOException {
		File directory = new File(folderPath);
		File directorySubFiles[] = directory.listFiles();
		File newFile = new File(newFilePath);
		for (File contents : directorySubFiles) {
			int indexOfExt = contents.getName().indexOf(".");
			String fileName = contents.getName().substring(0, indexOfExt);
			if (fileName.contentEquals(file))
				contents.renameTo(newFile);

		}
	}

	public static void createNewFile(String newFilePath) throws IOException {
		File directory = new File(newFilePath);
		directory.createNewFile();
	}

	public static void moveFile(String folderPath, String file, String newFilePath) throws IOException {
		File directory = new File(folderPath);
		File directorySubFiles[] = directory.listFiles();
		File newFile = new File(newFilePath);
		for (File contents : directorySubFiles) {
			int indexOfExt = contents.getName().indexOf(".");
			String fileName = contents.getName().substring(0, indexOfExt);
			if (fileName.contentEquals(file)) {
				contents.renameTo(newFile);
				contents.delete();
			}

		}
	}

	public static void deleteFile(String folderPath, String file) throws IOException {

		File directory = new File(folderPath);
		File directorySubFiles[] = directory.listFiles();
		for (File contents : directorySubFiles) {
			int indexOfExt = contents.getName().indexOf(".");
			String fileName = contents.getName().substring(0, indexOfExt);
			if (fileName.contentEquals(file)) {
				contents.delete();
			}

		}

	}
}
