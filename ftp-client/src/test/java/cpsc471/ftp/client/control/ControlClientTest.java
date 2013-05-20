package cpsc471.ftp.client.control;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Test for the control client
 */
@Test
public class ControlClientTest {

    private ControlClientImpl client;
    private Socket socket;

    @BeforeMethod
    public void setUp() {

        client = new ControlClientImpl();
        socket = mock(Socket.class);
        client.setSocket(socket);
    }

    /**
     * Instantiate client with invalid domain name
     */
    @Test(expectedExceptions = UnknownHostException.class)
    public void testInvalidDomainName() throws Exception {

        new ControlClientImpl("@%$!", (short)12);
    }

    /**
     * Valid domain name
     */
    public void testValidDomainName() throws Exception {

        // todo find a better way to test
        // these values are important. This test actually establishes
        // a socket with Google. There must be a better way to do this.
        // new ControlClientImpl("google.com", (short)80);
    }
//
//    /**
//     * Execute the ls command
//     */
//    public void testLs() {
//
//        PrintWriter socketWriter = mock(PrintWriter.class);
//        client.setSocketWriter(socketWriter);
//
//        client.ls();
//    }
}
