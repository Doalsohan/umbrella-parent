package com.umbrella.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ReferenceCountUtil;

public class DiscardServer {
    private final int port;

    public DiscardServer(int port){
        this.port = port;
    }

    public void run() throws Exception {
        // boss 事件组用于处理接受链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // worker 事件组用来处理已经被接收的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ChannelInboundHandler() {
                                @Override
                                public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
                                    ByteBuf in = (ByteBuf) o;
                                    try {
                                        while (in.isReadable()) {
                                            System.out.println((char) in.readByte());
                                            System.out.flush();
                                        }
                                    } finally {
                                        ReferenceCountUtil.release(o);
                                    }
                                }

                                @Override
                                public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                }

                                @Override
                                public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                    channelHandlerContext.close();
                                }

                                @Override
                                public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }
                            });
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture sync = b.bind(port).sync();
            // 等待服务器 socket 关闭
            sync.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();
    }


}
