package com.lucasangelo.controller;

import com.lucasangelo.model.Message;
import com.lucasangelo.service.MessageService;
import jakarta.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    private static final String EXPECTED_MESSAGE = "Hello, World!";

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    private Message expectedMessage;

    @Before
    public void setUp() {
        expectedMessage = new Message();
        expectedMessage.setText(EXPECTED_MESSAGE);
    }

    @Test
    public void testGetMessage() {
        // given
        when(messageService.getMessage()).thenReturn(expectedMessage);

        // when
        Message actualMessage = messageController.getMessage();

        // then
        assertEquals(EXPECTED_MESSAGE, actualMessage.getText());
    }
}
