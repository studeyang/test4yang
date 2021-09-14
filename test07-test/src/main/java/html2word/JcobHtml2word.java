//package html2word;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.nodes.Node;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class JcobHtml2word {
//
//    /**
//     * 创建空白文档_写入html_处理空白文档image_复制空白文档至最终文档
//     *
//     * @param html
//     * @param localpath
//     * @param researchId
//     */
//    public static String getWord(String html, String localpath, long researchId) {
//        // 下载图片到本地 略
//        // 图片在文档中的键${name} - 值图片的绝对路径    imgMap.put("${ABC}", localpath + "\\ABC.png");
//        Map<String, String> imgMap = new HashMap<String, String>();
//        // 解析html_创建空白文档_html写入空白文档
//        Document document = Jsoup.parse(html);
//        for (Element element : document.body().select("body > *")) {
//            sysElementText(element, localpath, imgMap);
//        }
//        createWord(localpath, "blank");
//        File doc = new File(localpath + File.separator + "blank.doc");
//        FileWriter fw;
//        try {
//            fw = new FileWriter(doc);
//            fw.write(document.html(), 0, document.html().length());// 写入文件
//            fw.flush(); // 清空FileWriter缓冲区
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String complete = String.valueOf(researchId);
//        // 复制空白文档-粘贴到临时文档（相当于手动执行copy_paste）
//        MSOfficeGeneratorUtils officeUtils = new MSOfficeGeneratorUtils(false);
//        officeUtils.openDocument(localpath + File.separator + "blank.doc");
//        officeUtils.copy(); // 拷贝整篇文档
//        officeUtils.close();
//        officeUtils.createNewDocument();
//        officeUtils.paste(); // 粘贴整篇文档
//        // 将图片${image_name}替换为真实图片
//        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
//            officeUtils.replaceText2Image(entry.getKey(), entry.getValue());
//        }
//
//        officeUtils.setFont(true, false, false, "0,0,0", "20", "宋体"); // 设置字体,具体参数
//        officeUtils.saveAs(localpath + File.separator + complete + ".doc"); // 可生成UUID.doc文件，利用UUID防止同名
//        officeUtils.close(); // 关闭Office Word创建的文档
//        officeUtils.quit(); // 退出Office Word程序
//        imgMap.clear();
//        return complete;
//    }
//
//    /**
//     *  替换img标签为p标签
//     *
//     * @param node
//     * @param imgPath 本地图片存储路径
//     * @param imgMap key：${imgName} value:
//     */
//    public static void sysElementText(Node node, String imgPath, Map<String, String> imgMap) {
//        if (node.childNodes().size() == 0) {
//            if (node.nodeName().equals("img")) {
//                String src = node.attr("src");
//                String fileName = src.substring(src.lastIndexOf("/") + 1, src.length());
//                Element element = new Element("p");
//                element.append("${"+fileName+"}");
//                element.attr("style", node.attr("style"));
//                node.replaceWith(element);
//                imgMap.put("${"+fileName+"}", imgPath + File.separator + fileName);
//            }
//        }
//        if (node.childNodes().size() > 0) {
//            List<Node> childNodes = node.childNodes();
//            for (Node node2 : childNodes) {
//                if (node2.nodeName().equals("img")) {
//                    String src = node2.attr("src");
//                    String fileName = src.substring(src.lastIndexOf("/") + 1, src.length());
//                    Element element = new Element("p");
//                    element.append("${"+fileName+"}");
//                    element.attr("style", node2.attr("style"));
//                    node2.replaceWith(element);
//                    imgMap.put("${"+fileName+"}", imgPath + File.separator + fileName);
//                }
//            }
//        }
//    }
//
//    /**
//     * 创建word文档
//     *
//     * @param localpath
//     * @param name
//     * @return
//     */
//    public static void createWord(String localpath, String name) {
//        MSOfficeGeneratorUtils msOfficeUtils = new MSOfficeGeneratorUtils(false); // 整合过程设置为可见
//        msOfficeUtils.createNewDocument();
//        msOfficeUtils.saveAs(localpath + File.separator + name + ".doc");
//        msOfficeUtils.close();
//        msOfficeUtils.quit();
//    }
//
//}
