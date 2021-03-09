import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Read {

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = session.createQueue("Session1");
        MessageConsumer messageConsumer = session.createConsumer(destination);
        Message message = messageConsumer.receive();
        TextMessage textMessage = (TextMessage) message;
        System.out.println(textMessage.getText());

        session.close();
        connection.close();

    }
}
