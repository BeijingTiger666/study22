package com.study.ws.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.*;
import java.net.MalformedURLException;

public class WStest {
    public static void main(String[] args) {

    }
    @Test
    public void sdfas(){
    }
@Test
    public void testPost() {
        String url2 = "http://192.168.1.208:8090/gpodec/webservice/supplierService";
        try {
            URL url = new URL(url2);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//如果打算使用 URL 连接进行输出，则将 DoOutput 标志设置为 true
            con.setDoOutput(true);
//设置第一次请求的数据内容不被存储
            con.setRequestProperty("Pragma:", "no-cache");
//设置请求的数据内容不被存储
            con.setRequestProperty("Cache-Control", "no-cache");
//设置请求的字符集编码格式,如果不指定，则默认采用16进制的字符集编码格式
            con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
//构造向指定链接写入数据的的输出流
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
//准备xml数据
            final String str = "hellosoap";
            String xmlInfo = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.ws.gpo.yy.com/\">"+"<soapenv:Header/>"
                    +"<soapenv:Body><ser:sendRecv4Supplier><!--Optional:--><sUser>zhuwei</sUser><!--Optional:--><sPwd>password</sPwd><!--Optional:--><sJgbm>GYSNB001</sJgbm><!--Optional:--><sVersion>1.0.0.0</sVersion><!--Optional:--><sXxlx>GS102</sXxlx><!--Optional:--><!--Optional:-->"
                    +"<xmlData>"+str+"</xmlData>"
                    +"</ser:sendRecv4Supplier></soapenv:Body></soapenv:Envelope>";
//向指定链接写入数据
            out.write(new String(xmlInfo));
            out.flush();
            out.close();
//将从服务端返回的数据读取到内存中
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = "";
//构造一个空的StringBuffer对象，用于存储内存中的数据
            StringBuffer buf = new StringBuffer();
            for (line = br.readLine(); line != null; line = br.readLine()) {
//由于服务端返回的数据的字符集编码有可能不是utf-8,需要对返回的数据通过指定的字符集进行解码
                buf.append(new String(line.getBytes(),"UTF-8"));
            }

//获取服务端返回的HttpCode
            int httpCode = con.getResponseCode();
//            System.out.println("HttpCode:"+httpCode+"  "+map.get("msgType")+"接口:"+buf.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//对webservice接口进行加密(SHA-1加密)
//        SoapKey soapKey = new SoapKey();
//        String key=soapKey.getMessageDigest(data, "SHA-1");

    public static String createXML(){
        String xmlStr="";
        //doc 的工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlVersion("1.0");
            //
            Element root = document.createElement("root");
            document.appendChild(root);
            //
            Element user = document.createElement("user");
            //
            Element id = document.createElement("id");
            id.setTextContent("1");
            user.appendChild(id);
            //
            Element name = document.createElement("name");
            name.setTextContent("张三");
            user.appendChild(name);
            //
            Element sex = document.createElement("sex");
            sex.setTextContent("男");
            user.appendChild(sex);
            //
            root.appendChild(user);
            //
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transFormer = transFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            //export string
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            transFormer.transform(domSource, new StreamResult(bos));
            xmlStr = bos.toString();
            System.out.println("输出结果"+xmlStr);
            //通过输出流输出
            File file = new File("D:/out/user.xml");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);
            StreamResult xmlResult = new StreamResult(out);
            transFormer.transform(domSource, xmlResult);
        }catch(Exception e){
            e.printStackTrace();
        }
        return xmlStr;
    }@Test
    public void testPos23242t() {String xmlStr="";
        //doc 的工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlVersion("1.0");
            //
            Element root = document.createElement("root");
            document.appendChild(root);
            //
            Element user = document.createElement("user");
            //
            Element id = document.createElement("id");
            id.setTextContent("1");
            user.appendChild(id);
            //
            Element name = document.createElement("name");
            name.setTextContent("张三");
            user.appendChild(name);
            //
            Element sex = document.createElement("sex");
            sex.setTextContent("男");
            user.appendChild(sex);
            //
            root.appendChild(user);
            //
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transFormer = transFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            //export string
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            transFormer.transform(domSource, new StreamResult(bos));
            xmlStr = bos.toString();
            System.out.println("输出结果"+xmlStr);
            //通过输出流输出
            File file = new File("D:/user.xml");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);
            StreamResult xmlResult = new StreamResult(out);
            transFormer.transform(domSource, xmlResult);
        }catch(Exception e){
            e.printStackTrace();
        }
}
}
