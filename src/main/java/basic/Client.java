package basic;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author mhh
 * @since 2020/12/7
 */
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.register(selector, SelectionKey.OP_WRITE);
        socketChannel.register(selector, SelectionKey.OP_READ);


        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8989));
        System.out.println(socketChannel.finishConnect());


        Socket socket = socketChannel.socket();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.flush();

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        for (SelectionKey selectionKey : selectionKeys) {
            System.out.println(selectionKey.isReadable());
            System.out.println(selectionKey.isConnectable());
            System.out.println(selectionKey.isWritable());
        }
    }
}
