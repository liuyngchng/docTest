package richard.test.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;

public class DocUtil {
    public static void readAndWriterTest3() throws IOException {
        File file = new File("C:\\Users\\tuzongxun123\\Desktop\\aa.doc");
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取doc文件内容
     *
     * @param file
     *            想要读取的文件对象
     * @return 返回文件内容
     * @throws IOException
     */
    public static String doc2String(FileInputStream fs) throws IOException {
        StringBuilder result = new StringBuilder();
        WordExtractor re = new WordExtractor(fs);
        result.append(re.getText());
        re.close();
        return result.toString();
    }

    public static String doc2String(File file) throws IOException {
        return doc2String(new FileInputStream(file));
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\frank.li\\Desktop\\产品购销合同范本1.doc");
        try {
            System.out.println(doc2String(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
