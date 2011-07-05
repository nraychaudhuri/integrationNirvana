package mailreader;

import com.growl.GrowlWrapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class UserCarOrderProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        String subject = exchange.getIn().getHeader("Subject").toString();
        String from = exchange.getIn().getHeader("From").toString();
        System.out.println("used car order received : (" + System.nanoTime() + ") - " + from + " : " + subject);

        sendGrowl(subject, from);
    }

    private void sendGrowl(String subject, String from) {
        String NOTIFICATION = "Used Car Order Received";
        GrowlWrapper gw = new GrowlWrapper("My App", "Finder", new String[]{NOTIFICATION}, new String[]{NOTIFICATION});
        gw.notify(NOTIFICATION, from, NOTIFICATION + " : " + subject);
    }
}
