package html2word;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class PoiHtml2word {

    /**
     * HTML转word
     *
     * @param wordFileName 导出文件名称
     * @param html         文件的html
     * @return void
     * @paramre portDirName 文件路径
     * @author Solitary
     * @date 2019/1/11 9:21
     */
    public static void htmlToWord(String wordFileName, String wordFilePath, String html) throws Exception {
        //拼一个标准的HTML格式文档
        Document document = Jsoup.parse(html);
        InputStream is = new ByteArrayInputStream(document.html().getBytes("GBK"));
        OutputStream os = new FileOutputStream(wordFilePath + wordFileName);
        POIFSFileSystem fs = new POIFSFileSystem();
        DirectoryNode root = fs.getRoot();
        root.createDocument("WordDocument", is);
        fs.writeFilesystem(os);
        os.close();
        is.close();
    }


}
