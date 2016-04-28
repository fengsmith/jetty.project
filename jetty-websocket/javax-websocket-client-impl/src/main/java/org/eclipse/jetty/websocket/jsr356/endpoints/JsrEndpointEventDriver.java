//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.jsr356.endpoints;

/**
 * EventDriver for websocket that extend from {@link javax.websocket.Endpoint}
 */
@Deprecated
public class JsrEndpointEventDriver extends AbstractJsrEventDriver
{
    /*private static final Logger LOG = Log.getLogger(JsrEndpointEventDriver.class);

    private final Endpoint endpoint;
    private Map<String, String> pathParameters;

    public JsrEndpointEventDriver(WebSocketPolicy policy, Executor executor, ConfiguredEndpoint endpointInstance)
    {
        super(policy,executor,endpointInstance);
        this.endpoint = (Endpoint)endpointInstance.getEndpoint();
    }

    @Override
    public void init(JsrSession jsrsession)
    {
        jsrsession.setPathParameters(pathParameters);
    }

    @Override
    public void onBinaryFrame(ByteBuffer buffer, boolean fin) throws IOException
    {
        if (activeMessage == null)
        {
            activeMessage = jsrsession.newMessageAppenderFor(MessageType.BINARY);
            if (activeMessage == null)
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("No BINARY MessageHandler declared");
                }
                return;
            }
            
            *//*
            if (wrapper.wantsPartialMessages())
            {
                activeMessage = new BinaryPartialMessage(wrapper);
            }
            else if (wrapper.wantsStreams())
            {
                final MessageInputStream stream = new MessageInputStream();
                activeMessage = stream;
                dispatch(new Runnable()
                {
                    @SuppressWarnings("unchecked")
                    @Override
                    public void run()
                    {
                        MessageHandler.Whole<InputStream> handler = (Whole<InputStream>)wrapper.getHandler();
                        handler.onMessage(stream);
                    }
                });
            }
            else
            {
                activeMessage = new BinaryWholeMessage(this,wrapper);
            }
             *//*
        }

        activeMessage.appendFrame(buffer,fin);

        if (fin)
        {
            activeMessage.messageComplete();
            activeMessage = null;
        }
    }

    @Override
    public void onBinaryMessage(byte[] data)
    {
        *//* Ignored, handled by BinaryWholeMessage *//*
    }
    
    @Override
    public void onObject(Object o)
    {
        // TODO: deliver to message handler
    }
    
    @Override
    protected void onClose(CloseReason closereason)
    {
        endpoint.onClose(this.jsrsession,closereason);
    }

    @Override
    public void onConnect()
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("onConnect({}, {})",jsrsession,config);
        }

        // Let unhandled exceptions flow out
        endpoint.onOpen(jsrsession,config);
    }

    @Override
    public void onError(Throwable cause)
    {
        try
        {
            endpoint.onError(jsrsession,cause);
        }
        catch (Throwable t)
        {
            LOG.warn("Unable to report to onError due to exception",t);
        }
    }

    @Override
    public void onFrame(Frame frame)
    {
        *//* Ignored, not supported by JSR-356 *//*
    }

    @Override
    public void onInputStream(InputStream stream)
    {
        *//* Ignored, handled by BinaryStreamMessage *//*
    }

    @Override
    public void onReader(Reader reader)
    {
        *//* Ignored, handled by TextStreamMessage *//*
    }

    @Override
    public void onTextFrame(ByteBuffer buffer, boolean fin) throws IOException
    {
        if (activeMessage == null)
        {
            activeMessage = jsrsession.newMessageAppenderFor(MessageType.TEXT);
            if (activeMessage == null)
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("No TEXT MessageHandler declared");
                }
                return;
            }
            
//            if (wrapper.wantsPartialMessages())
//            {
//                activeMessage = new TextPartialMessage(wrapper);
//            }
//            else if (wrapper.wantsStreams())
//            {
//                final MessageReader stream = new MessageReader(new MessageInputStream());
//                activeMessage = stream;
//
//                dispatch(new Runnable()
//                {
//                    @SuppressWarnings("unchecked")
//                    @Override
//                    public void run()
//                    {
//                        MessageHandler.Whole<Reader> handler = (Whole<Reader>)wrapper.getHandler();
//                        handler.onMessage(stream);
//                    }
//                });
//            }
//            else
//            {
//                activeMessage = new TextWholeMessage(this,wrapper);
//            }
        }

        activeMessage.appendFrame(buffer,fin);

        if (fin)
        {
            activeMessage.messageComplete();
            activeMessage = null;
        }
    }

    @Override
    public void onTextMessage(String message)
    {
        *//* Ignored, handled by TextWholeMessage *//*
    }

    @Override
    public void onPing(ByteBuffer buffer)
    {
        onPongMessage(buffer);
    }

    @Override
    public void onPong(ByteBuffer buffer)
    {
        onPongMessage(buffer);
    }

    private void onPongMessage(ByteBuffer buffer)
    {
        MessageSink appender = jsrsession.newMessageAppenderFor(MessageType.PONG);
        if (appender == null)
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("No PONG MessageHandler declared");
            }
            return;
        }

        ByteBuffer pongBuf = null;

        if (BufferUtil.isEmpty(buffer))
        {
            pongBuf = BufferUtil.EMPTY_BUFFER;
        }
        else
        {
            pongBuf = ByteBuffer.allocate(buffer.remaining());
            BufferUtil.put(buffer,pongBuf);
            BufferUtil.flipToFlush(pongBuf,0);
        }

        try
        {
            appender.appendFrame(pongBuf,true);
        }
        catch (IOException e)
        {
            LOG.debug(e);
        }
    }

    @Override
    public void setPathParameters(Map<String, String> pathParameters)
    {
        this.pathParameters = pathParameters;
    }

    @Override
    public String toString()
    {
        return String.format("%s[%s]",JsrEndpointEventDriver.class.getSimpleName(),endpoint.getClass().getName());
    }*/
}
