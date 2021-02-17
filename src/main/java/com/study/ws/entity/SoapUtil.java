package com.study.ws.entity;

import org.junit.Test;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
// https://blog.csdn.net/weixin_39494923/article/details/79348379
public class SoapUtil {
    private String addressUrl="http://XXXXXXXX";
    /**
     * 添加所需信息
     * @param bodyJsonStr  请求体json
     * @param svcname      服务名称
     * @param svccode      服务编码
     * @param svcver       服务版本
     * @param orisys       来源系统标识
     * @return
     */
    public String sendSoapXml(String bodyJsonStr,
                              String svcname, String svccode,
                              String svcver, String orisys 
                               ) {
        String AUTH_PREFIX = "cl";
        String AUTH_NS = "http://www.e-chinalife.com/soa/";
        String XSD_NS = "http://www.w3.org/2001/XMLSchema";
        String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";
        try {
            SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnFactory.createConnection();
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.setPrefix("soapenv");
            envelope.removeNamespaceDeclaration("SOAP-ENV");
//            envelope.setAttribute("xmlns:xsd", XSD_NS);
            envelope.setAttribute("xmlns:xsi", XSI_NS);
            envelope.setAttribute("xmlns:soa", AUTH_NS);
            //获取信封中需要填写的请求报文部分的句柄
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            //添加消息体以及json字符串
            SOAPBody body = envelope.getBody();
            body.setPrefix("soapenv");
            SOAPBodyElement bodyElement = body.addBodyElement(envelope.createName("execute", "soa", null));
            SOAPElement requestData = bodyElement.addChildElement("requestData","soa");
            requestData.addTextNode(judgeNull(bodyJsonStr));
            SOAPHeader header = envelope.getHeader();
            header.setPrefix("soapenv");
            SOAPElement wsHeaderElm = soapFactory.createElement("HEADER", AUTH_PREFIX, AUTH_NS);
            SOAPElement svcnameElm = soapFactory.createElement("SVCNAME");
            SOAPElement svccodeNameElm = soapFactory.createElement("SVCCODE");
            SOAPElement svcverElm = soapFactory.createElement("SVCVER");
            SOAPElement orisysElm = soapFactory.createElement("ORISYS");
            SOAPElement trantimeElm = soapFactory.createElement("TRANTIME");
            SOAPElement trannoElm = soapFactory.createElement("TRANNO");
            SOAPElement authElm = soapFactory.createElement("AUTH");
            SOAPElement securityElm = soapFactory.createElement("SECURITY");
            SOAPElement routeElm = soapFactory.createElement("ROUTE");
            SOAPElement branchnoElm = soapFactory.createElement("BRANCHNO");
            SOAPElement useridElm = soapFactory.createElement("USERID");
            SOAPElement tokenidElm = soapFactory.createElement("TOKENID");
            SOAPElement signatureElm = soapFactory.createElement("SIGNATURE");
            SOAPElement branchnooElm = soapFactory.createElement("BRANCHNO");
            SOAPElement destsysElm = soapFactory.createElement("DESTSYS");
            svcnameElm.addTextNode(judgeNull(svcname));
            svccodeNameElm.addTextNode(judgeNull(svccode));
            svcverElm.addTextNode(judgeNull(svcver));
            orisysElm.addTextNode(judgeNull(orisys));
            authElm.addChildElement(branchnoElm);
            authElm.addChildElement(useridElm);
            authElm.addChildElement(tokenidElm);
            securityElm.addChildElement(signatureElm);
            routeElm.addChildElement(branchnooElm);
            routeElm.addChildElement(destsysElm);
            wsHeaderElm.addChildElement(svcnameElm);
            wsHeaderElm.addChildElement(svccodeNameElm);
            wsHeaderElm.addChildElement(svcverElm);
            wsHeaderElm.addChildElement(orisysElm);
            wsHeaderElm.addChildElement(trantimeElm);
            wsHeaderElm.addChildElement(trannoElm);
            wsHeaderElm.addChildElement(authElm);
            wsHeaderElm.addChildElement(securityElm);
            wsHeaderElm.addChildElement(routeElm);
            header.addChildElement(wsHeaderElm);
            message.saveChanges();
            System.out.println("输出报文，如下：");
            message.writeTo(System.out);
            //发送信息
            SOAPMessage call = connection.call(message, addressUrl);
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            Source sourceContent = call.getSOAPPart().getContent();
            StreamResult result = new StreamResult(new ByteArrayOutputStream());
            transformer.transform(sourceContent,result);
            //获取返回报文
            String s = ((ByteArrayOutputStream) result.getOutputStream()).toString();
            System.out.println("返回报文,如下：");
            System.out.print( s);
            connection.close();
            return s;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return AUTH_PREFIX;
    }
    public static  String  judgeNull(String str){
        return (str==null)?"":str;
    }

    public SoapUtil() {  }

     
    public void createsoapmsg(SOAPMessage message) throws SOAPException {
            String AUTH_PREFIX = "cl";
            String AUTH_NS = "http://www.e-chinalife.com/soa/";
            String XSD_NS = "http://www.w3.org/2001/XMLSchema";
            String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";
            try {
                SOAPPart soapPart = message.getSOAPPart();
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.setPrefix("soapenv");
                envelope.removeNamespaceDeclaration("SOAP-ENV");
//            envelope.setAttribute("xmlns:xsd", XSD_NS);
                envelope.setAttribute("xmlns:xsi", XSI_NS);
                envelope.setAttribute("xmlns:soa", AUTH_NS);
                SOAPFactory soapFactory = SOAPFactory.newInstance();
                SOAPBody body = envelope.getBody();
                body.setPrefix("soapenv");
                SOAPBodyElement bodyElement = body.addBodyElement(envelope.createName("execute", "soa", null));
                SOAPElement requestData = bodyElement.addChildElement("requestData","soa");
                SOAPHeader header = envelope.getHeader();
                header.setPrefix("soapenv");
                SOAPElement wsHeaderElm = soapFactory.createElement("HEADER", AUTH_PREFIX, AUTH_NS);
                SOAPElement svcnameElm = soapFactory.createElement("SVCNAME");
                SOAPElement svccodeNameElm = soapFactory.createElement("SVCCODE");
                SOAPElement svcverElm = soapFactory.createElement("SVCVER");
                SOAPElement orisysElm = soapFactory.createElement("ORISYS");
                SOAPElement trantimeElm = soapFactory.createElement("TRANTIME");
                SOAPElement trannoElm = soapFactory.createElement("TRANNO");
                SOAPElement authElm = soapFactory.createElement("AUTH");
                SOAPElement securityElm = soapFactory.createElement("SECURITY");
                SOAPElement routeElm = soapFactory.createElement("ROUTE");
                SOAPElement branchnoElm = soapFactory.createElement("BRANCHNO");
                SOAPElement useridElm = soapFactory.createElement("USERID");
                SOAPElement tokenidElm = soapFactory.createElement("TOKENID");
                SOAPElement signatureElm = soapFactory.createElement("SIGNATURE");
                SOAPElement branchnooElm = soapFactory.createElement("BRANCHNO");
                SOAPElement destsysElm = soapFactory.createElement("DESTSYS");
                authElm.addChildElement(branchnoElm);
                authElm.addChildElement(useridElm);
                authElm.addChildElement(tokenidElm);
                securityElm.addChildElement(signatureElm);
                routeElm.addChildElement(branchnooElm);
                routeElm.addChildElement(destsysElm);
                wsHeaderElm.addChildElement(svcnameElm);
                wsHeaderElm.addChildElement(svccodeNameElm);
                wsHeaderElm.addChildElement(svcverElm);
                wsHeaderElm.addChildElement(orisysElm);
                wsHeaderElm.addChildElement(trantimeElm);
                wsHeaderElm.addChildElement(trannoElm);
                wsHeaderElm.addChildElement(authElm);
                wsHeaderElm.addChildElement(securityElm);
                wsHeaderElm.addChildElement(routeElm);
                header.addChildElement(wsHeaderElm);
                message.saveChanges();
                System.out.println("输出报文，如下：");
                message.writeTo(System.out);
    } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws SOAPException, TransformerException, IOException {
        String bodyJsonStr = "紧急进击军军";
            String AUTH_PREFIX = "cl";
            String AUTH_NS = "http://www.e-chinalife.com/soa/";
            String XSD_NS = "http://www.w3.org/2001/XMLSchema";
            String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";
                SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
                SOAPConnection connection = soapConnFactory.createConnection();
                MessageFactory messageFactory = MessageFactory.newInstance();
                SOAPMessage message = messageFactory.createMessage();
                SOAPPart soapPart = message.getSOAPPart();
                SOAPEnvelope envelope = soapPart.getEnvelope();
                envelope.setPrefix("soapenv");
                envelope.removeNamespaceDeclaration("SOAP-ENV");
//            envelope.setAttribute("xmlns:xsd", XSD_NS);
                envelope.setAttribute("xmlns:xsi", XSI_NS);
                envelope.setAttribute("xmlns:soa", AUTH_NS);
                //获取信封中需要填写的请求报文部分的句柄
                SOAPFactory soapFactory = SOAPFactory.newInstance();
                //添加消息体以及json字符串
                SOAPBody body = envelope.getBody();
                body.setPrefix("soapenv");
                SOAPBodyElement bodyElement = body.addBodyElement(envelope.createName("execute", "soa", null));
                SOAPElement requestData = bodyElement.addChildElement("requestData","soa");
                requestData.addTextNode(judgeNull(bodyJsonStr));
                SOAPHeader header = envelope.getHeader();
                header.setPrefix("soapenv");
                SOAPElement wsHeaderElm = soapFactory.createElement("HEADER", AUTH_PREFIX, AUTH_NS);
                SOAPElement svcnameElm = soapFactory.createElement("SVCNAME");
                SOAPElement svccodeNameElm = soapFactory.createElement("SVCCODE");
                SOAPElement svcverElm = soapFactory.createElement("SVCVER");
                SOAPElement orisysElm = soapFactory.createElement("ORISYS");
                SOAPElement trantimeElm = soapFactory.createElement("TRANTIME");
                SOAPElement trannoElm = soapFactory.createElement("TRANNO");
                SOAPElement authElm = soapFactory.createElement("AUTH");
                SOAPElement securityElm = soapFactory.createElement("SECURITY");
                SOAPElement routeElm = soapFactory.createElement("ROUTE");
                SOAPElement branchnoElm = soapFactory.createElement("BRANCHNO");
                SOAPElement useridElm = soapFactory.createElement("USERID");
                SOAPElement tokenidElm = soapFactory.createElement("TOKENID");
                SOAPElement signatureElm = soapFactory.createElement("SIGNATURE");
                SOAPElement branchnooElm = soapFactory.createElement("BRANCHNO");
                SOAPElement destsysElm = soapFactory.createElement("DESTSYS");
                authElm.addChildElement(branchnoElm);
                authElm.addChildElement(useridElm);
                authElm.addChildElement(tokenidElm);
                securityElm.addChildElement(signatureElm);
                routeElm.addChildElement(branchnooElm);
                routeElm.addChildElement(destsysElm);
                wsHeaderElm.addChildElement(svcnameElm);
                wsHeaderElm.addChildElement(svccodeNameElm);
                wsHeaderElm.addChildElement(svcverElm);
                wsHeaderElm.addChildElement(orisysElm);
                wsHeaderElm.addChildElement(trantimeElm);
                wsHeaderElm.addChildElement(trannoElm);
                wsHeaderElm.addChildElement(authElm);
                wsHeaderElm.addChildElement(securityElm);
                wsHeaderElm.addChildElement(routeElm);
                header.addChildElement(wsHeaderElm);
                message.saveChanges();
                System.out.println("输出报文，如下：");
                message.writeTo(System.out);
//                //发送信息
//                SOAPMessage call = connection.call(message, addressUrl);
//                TransformerFactory transformerFactory=TransformerFactory.newInstance();
//                Transformer transformer = transformerFactory.newTransformer();
//                Source sourceContent = call.getSOAPPart().getContent();
//                StreamResult result = new StreamResult(new ByteArrayOutputStream());
//                transformer.transform(sourceContent,result);
//                //获取返回报文
//                String s = ((ByteArrayOutputStream) result.getOutputStream()).toString();
//                System.out.println("返回报文,如下：");
//                System.out.print( s);
    }
}
