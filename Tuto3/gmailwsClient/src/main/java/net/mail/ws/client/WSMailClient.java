package net.mail.ws.client;
import net.mail.ws.client.MyOwnMailAgent;
import net.mail.ws.client.WSMail;

public class WSMailClient {
public static void main (String[] args) {

    MyOwnMailAgent service =new MyOwnMailAgent();
    WSMail mail = service.getWSMailImplPort();
    mail.sendMail("smtp.gmail.com", 465 ,"bta134@gmail.com", "shiying_fei@yahoo.com","bta134","greendragon", true);
    }
}
