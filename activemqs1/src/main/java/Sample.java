import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sample {



    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("Session1");
        MessageProducer msgProducer = session.createProducer(destination);
        msgProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        Message message = session.createTextMessage("This is session1");
        msgProducer.send(message);
        session.close();
        connection.close();
    }
}
