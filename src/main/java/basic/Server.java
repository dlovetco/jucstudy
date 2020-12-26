package basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author mhh
 * @since 2020/12/7
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //ServerSocketChannel用来接收连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8989));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println(selector.selectedKeys().size());

        while (selector.selectedKeys().size()<2){
            selector.select();
        }
        System.out.println(selector.selectedKeys().size());
        //ServerSocketChannel做的事情已经完了 后面要交给SocketChannel处理
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        SelectionKey register = socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        System.out.println(register.isReadable());
        System.out.println(register.isWritable());
        selector.select();
        System.out.println(register.isReadable());
        System.out.println(register.isWritable());
//            accept.read()


    }
}
